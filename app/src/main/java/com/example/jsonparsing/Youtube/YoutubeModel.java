package com.example.jsonparsing.Youtube;

public class YoutubeModel {
    String title,date,name,web;

    public YoutubeModel(String title, String date, String name) {
        this.title = title;
        this.date = date;
        this.name = name;
    }

        public YoutubeModel(String title, String date, String web, String name) {
        this.title = title;
        this.date = date;
        this.web = web;
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
