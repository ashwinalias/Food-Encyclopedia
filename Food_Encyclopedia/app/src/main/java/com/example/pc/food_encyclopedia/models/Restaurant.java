package com.example.pc.food_encyclopedia.models;

/**
 * Created by user on 17-09-2018.
 */

public class Restaurant {
    private String name;
    private int rating;
    private String mLocation;

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecName(String location) {
        this.mLocation = location ;
    }
}
