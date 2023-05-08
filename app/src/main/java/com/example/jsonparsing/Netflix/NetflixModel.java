package com.example.jsonparsing.Netflix;

public class NetflixModel {
    String web,title;

    public NetflixModel(String web, String title) {
        this.web = web;
        this.title = title;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
