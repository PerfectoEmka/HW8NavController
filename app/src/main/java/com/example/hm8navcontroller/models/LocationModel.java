package com.example.hm8navcontroller.models;

import java.io.Serializable;

public class LocationModel implements Serializable {

    private String title, type, image;

    public LocationModel(String title, String type, String image) {
        this.title = title;
        this.type = type;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }
}
