//package com.network.backend.model;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import javax.validation.constraints.NotBlank;
//import java.util.UUID;
//
//public class Scanner {
//    private final UUID id;
//    @NotBlank
//    private final String username;
//    private final String ip_address;
//    private final int scanned_amount;
//    private final int time_since_last_scan_for_this_ip;
//    private final int[] ports_opened;
//    private final float wait_time;
//
//
//
//    public Scanner(@JsonProperty("id") UUID id,
//                @JsonProperty("username") String username,
//                @JsonProperty("ip_address") String ip_address,
//                @JsonProperty("scanned_amount") int scanned_amount,
//                @JsonProperty("time_since_last_scan_for_this_ip") int time_since_last_scan_for_this_ip,
//                @JsonProperty("ports_opened") int[] ports_opened,
//                   @JsonProperty("wait_time") float wait_time
//    ) {
//        this.id = id;
//        this.username = username;
//        this.ip_address = ip_address;
//        this.scanned_amount = scanned_amount;
//        this.time_since_last_scan_for_this_ip = time_since_last_scan_for_this_ip;
//        this.ports_opened = ports_opened;
//        this.wait_time = wait_time;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getIpAddress() {return ip_address;}
//
//    public String getScan() {return last_name;}
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//}
