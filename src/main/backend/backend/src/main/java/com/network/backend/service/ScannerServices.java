package com.network.backend.service;
import com.network.backend.dao.ScannerDataAccessService;
import com.network.backend.model.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.*;
@Service
public class ScannerServices {

    private static ScannerDataAccessService scannerDao;

    @Autowired
    public ScannerServices(@Qualifier("Scanner-postgres") ScannerDataAccessService scannerDao) {
        this.scannerDao = scannerDao;
    }

    public static Optional<Scanner> getOpenPorts(Scanner scanner) {
        return scannerDao.getOpenPorts(scanner);
    }


    public int portScan(Scanner scanner) {
        ConcurrentLinkedQueue openPorts = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(200); // higher the treads, the faster the scan will be
        AtomicInteger port = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        while (port.get() < 10000) {
            final int currentPort = port.getAndIncrement();
            executorService.submit(() -> {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(scanner.getIp_address(), currentPort), 200);
                    socket.close();
                    openPorts.add(currentPort);
                } catch (IOException e) {
                }

            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List openPortList = new ArrayList();

        while (!openPorts.isEmpty()) {
            openPortList.add(openPorts.poll());
        }


        int length = openPortList.size();

        int openPortsArray[] = new int[length];
        for(int i=0; i<length; i++){
            openPortsArray[i] = (Integer) openPortList.get(i);
        }


        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000;
        // time is in seconds
        return scannerDao.postScan(openPortsArray, time, scanner);
    }
}
