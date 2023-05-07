package com.example.jsonparsing.JokesRiddle;

public class JokesModel {
    private String jokes,answer;

    public JokesModel(String jokes, String answer) {
        this.jokes = jokes;
        this.answer = answer;
    }

    public String getJokes() {
        return jokes;
    }

    public void setJokes(String jokes) {
        this.jokes = jokes;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
