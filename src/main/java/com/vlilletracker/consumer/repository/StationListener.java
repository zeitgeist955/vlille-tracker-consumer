package com.vlilletracker.consumer.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlilletracker.consumer.model.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StationListener {

    public void onMessage(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Station station = objectMapper.readValue(message, Station.class);
            log.info(station.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
