package com.example.annong_seonmi.utils.enums;

public enum Extras {

    CROP_NAME_KEY("CropName");

    private final String key;

    Extras(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
