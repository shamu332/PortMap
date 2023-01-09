package com.network.backend.controller;

import com.network.backend.model.Scanner;
import com.network.backend.service.ScannerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/scanner")
@RestController
public class ScannerController {

    private final ScannerServices scannerServices;

    @Autowired
    public ScannerController(ScannerServices scannerServices) {
        this.scannerServices = scannerServices;
    }

    @PostMapping
    public void postScanResults(@Valid @RequestBody Scanner scanner) {
        scannerServices.portScan(scanner);
    }

    @GetMapping("{ip_address}")
    public Optional<Scanner> getScanResults(Scanner scanner) {
        return ScannerServices.getOpenPorts(scanner);
    }
}
