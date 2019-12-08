package com.example.food_order_and_delivery.model;

public class Comments {

    private  String name;
    private  String comment;

    public Comments(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
