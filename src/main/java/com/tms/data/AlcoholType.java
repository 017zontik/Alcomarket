package com.tms.data;

public class AlcoholType {
    private String type;
    private int id;

    public String getTypeName() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlcoholType(String type, int id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "AlcoholType:" +
                "type='" + type + '\'' +
                ", id=" + id ;
    }
}
