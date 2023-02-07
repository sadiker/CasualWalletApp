package com.example.casualwalletapp.models.weather;



public class ResponseWeather {

    private Current current;

    private Location location ;


    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}


