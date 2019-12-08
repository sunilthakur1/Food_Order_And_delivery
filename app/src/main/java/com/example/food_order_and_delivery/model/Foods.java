package com.example.food_order_and_delivery.model;

public class Foods {
    private String fname;
    private String fprice;
    private String desc;

    public Foods(String fname, String fPrice, String desc ) {
        this.fname = fname;
        this.fprice = fPrice;
        this.desc = desc;

    }

    public String getFname() {
        return fname;
    }

    public String getFprice() {
        return fprice;
    }

    public String getDesc() {
        return desc;
    }
}
