package com.example.arpityadav.animalsapplication;

/**
 * Created by Arpit Yadav on 7/6/2017.
 */

public class Pins {
    private String name;
    private double longitude;
    private double latitude;

    public Pins(String name, double longitude, double latitude){
        this.name= name;
        this.longitude= longitude;
        this.latitude= latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
