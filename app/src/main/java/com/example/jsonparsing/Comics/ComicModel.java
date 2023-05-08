package com.example.jsonparsing.Comics;

public class ComicModel {
private String title,web;

    public ComicModel(String title, String web) {
        this.title = title;
        this.web = web;
    }

    public ComicModel(String title) {
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
