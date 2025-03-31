package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
public class MySQLController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySQLController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public String testMySQLConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "MySQL connection is successful!";
        } catch (Exception e) {
            return "MySQL connection failed: " + e.getMessage();
        }
    }
}
