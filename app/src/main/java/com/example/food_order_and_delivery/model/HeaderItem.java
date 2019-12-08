package com.example.food_order_and_delivery.model;

import com.yuyang.stickyheaders.StickyHeaderModel;

public class HeaderItem implements StickyHeaderModel {

    public final String title;


    public int color = 0xff777777;

    public HeaderItem(String title) {
        this.title = title;
    }
}
