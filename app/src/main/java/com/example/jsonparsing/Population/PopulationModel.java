package com.example.jsonparsing.Population;

public class PopulationModel {
    String country,population;

    public PopulationModel(String country, String population) {
        this.country = country;
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }
}
