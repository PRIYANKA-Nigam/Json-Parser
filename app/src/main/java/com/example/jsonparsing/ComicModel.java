package com.example.jsonparsing;

public class ComicModel {
private String image,title;

//    public ComicModel(String image, String title, String comic) {
//        this.image = image;
//        this.title = title;
//        this.comic = comic;
//    }

//    public String getComic() {
//        return comic;
//    }
//
//    public void setComic(String comic) {
//        this.comic = comic;
//    }

    public ComicModel(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
