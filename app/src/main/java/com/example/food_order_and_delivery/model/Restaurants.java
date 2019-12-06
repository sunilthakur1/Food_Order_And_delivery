package com.example.food_order_and_delivery.model;

public class Restaurants {
    private String name;
    private String location;
    private  String phone;
    private int img;


    public Restaurants(String name, String location, String phone, int img) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public int getImg() {
        return img;
    }
}
