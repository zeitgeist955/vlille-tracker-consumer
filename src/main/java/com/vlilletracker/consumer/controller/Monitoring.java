package com.vlilletracker.consumer.controller;

import com.vlilletracker.consumer.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Monitoring {

    @Autowired
    private CustomProperties customProperties;

    @GetMapping("/ping")
    public String testPing() {
        //test endpoint to check if the application is online and reachable
        return customProperties.getApplicationDesignation()+" is online and running !";
    }
}

