package com.example.annong_seonmi.utils.enums;

public enum AppResourceName {

    CROPS_LIST_FILE_NAME("cropsList.csv");

    private final String resourceName;


    AppResourceName(String resourceName){
        this.resourceName = resourceName;
    }

    public String getValue(){
        return this.resourceName;
    }

}
