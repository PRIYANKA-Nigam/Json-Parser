package com.example.jsonparsing.Bollywood;

public class BollywoodModel {
    String title,year,genre,story,actors,image;

    public BollywoodModel(String title, String year, String genre, String story, String actors, String image) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.story = story;
        this.actors = actors;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
