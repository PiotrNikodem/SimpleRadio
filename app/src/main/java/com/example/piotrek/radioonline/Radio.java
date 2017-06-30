package com.example.piotrek.radioonline;

/**
 * Created by Piotrek on 2017-05-15.
 */

public class Radio {

    private String name;
    private String url;

    public Radio(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }
}
