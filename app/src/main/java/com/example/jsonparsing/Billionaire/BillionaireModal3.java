package com.example.jsonparsing.Billionaire;

public class BillionaireModal3 {
    String name,worth,bulk,industries,rank;

    public BillionaireModal3(String name, String worth, String bulk, String industries,String rank) {
        this.name = name;
        this.worth = worth;
        this.bulk = bulk;
        this.industries = industries;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
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
