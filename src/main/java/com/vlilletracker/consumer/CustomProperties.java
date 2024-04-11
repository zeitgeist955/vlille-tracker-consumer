package com.vlilletracker.consumer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.vlilletracker.consumer")
public class CustomProperties {

    private String applicationDesignation;

    private String kafkaTopicName;
}
