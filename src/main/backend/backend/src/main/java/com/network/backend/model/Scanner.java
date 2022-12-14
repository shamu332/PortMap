package com.network.backend.model;


import java.util.ArrayList;

public class Scanner {
    private final String ip_address;

    public final ArrayList ports_opened;
    private final Float wait_time;



    public Scanner(String ip_address, ArrayList ports_opened, Float wait_time) {
        this.ip_address = ip_address;
        this.ports_opened = ports_opened;
        this.wait_time = wait_time;
    }



    public String getIp_address() {
        return ip_address;
    }

    public ArrayList getPorts_opened() {
        return ports_opened;
    }

    public Float getWait_time() {
        return wait_time;
    }


}
