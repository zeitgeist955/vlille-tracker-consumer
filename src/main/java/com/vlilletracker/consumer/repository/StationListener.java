package com.vlilletracker.consumer.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlilletracker.consumer.model.Station;
import com.vlilletracker.consumer.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class StationListener {

    @Autowired
    private StationService stationService;

    public void onMessage(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Station station = objectMapper.readValue(message, Station.class);
            stationService.handleStationUpdate(station);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
