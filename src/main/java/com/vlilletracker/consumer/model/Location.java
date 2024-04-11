package com.vlilletracker.consumer.model;

import lombok.Data;

@Data
public class Location {

    //Longitude
    private double lon;

    //Latitude
    private double lat;

    public Location() {
    }

    public Location(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }
}
