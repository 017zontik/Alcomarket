package com.tms.data;

public class Alcohol {
    private String name;
    private double price;
    private AlcoholType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AlcoholType getType() {
        return type;
    }

    public void setType(AlcoholType type) {
        this.type = type;
    }

    public Alcohol(String name, double price, AlcoholType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Alcohol:" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type ;
    }
}
