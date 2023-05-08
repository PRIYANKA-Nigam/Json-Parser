package com.example.jsonparsing.Singers;

public class SingerModal {
    String name,followers,web;
  String  image;
    String genres;

    public SingerModal(String name, String genres, String followers, String image) {
        this.name = name;
        this.genres = genres;
        this.followers = followers;
        this.image = image;
    }

    public SingerModal(String name, String followers, String web, String image, String genres) {
        this.name = name;
        this.followers = followers;
        this.web = web;
        this.image = image;
        this.genres = genres;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
