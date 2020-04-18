package com.tms.data;

public class Alcohol {
    private int id;
    private String name;
    private double price;
    private AlcoholType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Alcohol(int id, String name, double price, AlcoholType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
