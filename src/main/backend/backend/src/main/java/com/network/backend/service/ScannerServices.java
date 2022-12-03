package com.network.backend.service;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.*;

public class ScannerServices {

    public static void main(String[] args) {
        portScan("127.0.0.1");
        //openPorts.forEach(port -> System.out.println("port " + port + " is open"));
    }

    public static List portScan(String ip) {
        ConcurrentLinkedQueue openPorts = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(200); // higher the treads, the faster the scan will be
        AtomicInteger port = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        while (port.get() < 10000) {
            final int currentPort = port.getAndIncrement();
            executorService.submit(() -> {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, currentPort), 200);
                    socket.close();
                    openPorts.add(currentPort);
                    System.out.println(ip + " ,port open: " + currentPort);
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

        List openPortList = new ArrayList<>();
        // System.out.println("openPortsQueue: " + openPorts.size());
        while (!openPorts.isEmpty()) {
            openPortList.add(openPorts.poll());
        }
        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000;
        System.out.println("The process took " + time + " seconds");
        return openPortList;
    }
}
