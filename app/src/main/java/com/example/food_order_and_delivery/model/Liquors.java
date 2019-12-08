package com.example.food_order_and_delivery.model;

public class Liquors {
    private String liqname;
    private String lprice;
    private String descrip;

    public Liquors(String liqname, String lprice, String descrip){
        this.liqname = liqname;
        this.lprice = lprice;
        this.descrip = descrip;
    }

    public String getLiqname() {return liqname;
    }

    public String getLprice() {return lprice;
    }

    public String getDescrip() {return descrip;
    }
}
