package com.network.backend.dao;


import com.network.backend.model.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository("Scanner-postgres")
public class ScannerDataAccessService {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ScannerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int postScan(int[] openPortsArray,float wait_time, Scanner scanner) {
        String sql = "" +
                "INSERT INTO ip_log (" +
                "ip_" +
                "address, " +
                "ports_opened, " +
                "wait_time) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                scanner.getIp_address(),
                openPortsArray,
                wait_time
        );
    }

    public Optional<Scanner> getOpenPorts(Scanner parameter_scanner) {
        final String sql = "" +
                "select " +
                "ip_address, " +
                "ports_opened, " +
                "wait_time " +
                "from ip_log where " +
                "ip_address=? " +
                "order by id desc limit 1";
        Scanner scanner = jdbcTemplate.queryForObject(
                sql,
                new Object[]{parameter_scanner.getIp_address()},
                (resultSet, i) -> {
                    String ip = resultSet.getString("ip_address");
                    String ports_opened = resultSet.getString("ports_opened");
                    Float wait_time = (Float.parseFloat(resultSet.getString("wait_time")));
                    ArrayList converted_ports_opened = convertPortsOpened(ports_opened);
                    return new Scanner( ip, converted_ports_opened, wait_time);
                });
        return Optional.ofNullable(scanner);
    }
    public ArrayList convertPortsOpened (String ports_opened) { //converting the ports_opened from the database into an arraylist because PgArray decides to be difficult
        String numConverter = "";
        ArrayList arr = new ArrayList();
        for (int i = 0; i<ports_opened.length();i++) {
            char charOfPortsOpened = ports_opened.charAt(i);
            if (charOfPortsOpened == '{' || charOfPortsOpened == ' ') { // character we do not care about
                continue;
            }
            else if (charOfPortsOpened == ',' || charOfPortsOpened == '}') { // if char of ',' will start the conversion process for each opened ports and char '}' to get the last opened port to be converted
                int convert = Integer.parseInt(numConverter);
                arr.add(convert);
                numConverter = "";
            }
            else { // add the string from ports_opened to a String variable to later on to be converted into an integer
                numConverter += charOfPortsOpened;
            }
        }
        return arr;
    }


}
