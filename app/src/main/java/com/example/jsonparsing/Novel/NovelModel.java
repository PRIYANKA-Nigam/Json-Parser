package com.example.jsonparsing.Novel;

public class NovelModel {
    String web,title,author;

    public NovelModel(String image, String title, String author) {
        this.web = image;
        this.title = title;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
