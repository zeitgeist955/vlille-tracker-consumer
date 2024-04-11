package com.vlilletracker.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private CustomProperties customProperties;

    public void run(String... args) {
        log.info("{} app is live and running !", customProperties.getApplicationDesignation());
    }
}
