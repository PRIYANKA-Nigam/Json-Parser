package com.example.jsonparsing.Dance;

public class DanceModel {
    String web,title;


    public DanceModel( String title,String web) {
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
