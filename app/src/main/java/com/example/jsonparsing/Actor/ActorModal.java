package com.example.jsonparsing.Actor;

public class ActorModal {
    String name,alt,rating;

    public ActorModal(String name, String alt, String rating) {
        this.name = name;
        this.alt = alt;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
