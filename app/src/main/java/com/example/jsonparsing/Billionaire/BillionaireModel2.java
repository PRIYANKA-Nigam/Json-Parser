package com.example.jsonparsing.Billionaire;

public class BillionaireModel2 {
    String name,worth,bulk,industries;

    public BillionaireModel2(String name, String worth, String bulk, String industries) {
        this.name = name;
        this.worth = worth;
        this.bulk = bulk;
        this.industries = industries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    public String getIndustries() {
        return industries;
    }

    public void setIndustries(String industries) {
        this.industries = industries;
    }
}
