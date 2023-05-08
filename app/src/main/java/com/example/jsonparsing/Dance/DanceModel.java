package com.example.jsonparsing.Dance;

public class DanceModel {
    String web,title,desc;

    public DanceModel(String image, String title, String author) {
        this.web = image;
        this.title = title;
        this.desc = author;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
