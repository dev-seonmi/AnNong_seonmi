package com.example.annong_seonmi.utils.enums;

public enum AppResourceExtensions {
    JSON(".json"),
    CSV(".csv");

    private final String fileExtension;

    AppResourceExtensions(String fileExtension){
        this.fileExtension = fileExtension;
    }

    public String getFileExtension(){
        return this.fileExtension;
    }
}
