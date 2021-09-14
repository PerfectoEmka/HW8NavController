package com.example.hm8navcontroller.models;

import java.io.Serializable;

public class CharacterModel implements Serializable {
    private String deadAliveStatus, name, image;

    public CharacterModel(String deadAliveStatus, String name, String image) {
        this.deadAliveStatus = deadAliveStatus;
        this.name = name;
        this.image = image;
    }

    public String getDeadAliveStatus() {
        return deadAliveStatus;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
