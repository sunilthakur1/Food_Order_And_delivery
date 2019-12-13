package com.example.food_order_and_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.food_order_and_delivery.model.Foods;
import com.example.food_order_and_delivery.model.Liquors;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView liquirRecy;
    private List<Liquors> liquorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        liquirRecy = findViewById(R.id.liquorRec);

        liquorList.add(new Liquors("Blacklabel", "1000", "this is best wiskey"));
        liquorList.add(new Liquors("Redlabel", "1110", "wiskey second "));
        liquorList.add(new Liquors("8848", "2000", "vodka"));
        liquorList.add(new Liquors("Bigmaster", "610", "wine"));
        liquorList.add(new Liquors("golden Oak", "800", "cheap and best wiskey"));



    }
}
