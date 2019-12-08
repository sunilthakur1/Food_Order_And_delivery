package com.example.food_order_and_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.food_order_and_delivery.adapters.RestaurantMenuRecyclerAdapter;
import com.example.food_order_and_delivery.model.Foods;
import com.example.food_order_and_delivery.model.HeaderItem;
import com.example.food_order_and_delivery.model.Comments;
import com.yuyang.stickyheaders.StickyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    private RecyclerView foodListView,commentsview;
    private List<Foods> foodList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);

//        foodListView = findViewById(R.id.foodlistview);

        foodList.add(new Foods("Alloo", "Rs 600", "This is the best aloo"));
        foodList.add(new Foods("mo:mo", "Rs 120" , "This is the momo"));

//        FoodListAdapter foodsAdapter = new FoodListAdapter(this, foodList);
//
//        foodListView.setLayoutManager(new LinearLayoutManager(this));
//
//        foodListView.setAdapter(foodsAdapter);
        commentsview = findViewById(R.id.commentsview);

        final RestaurantMenuRecyclerAdapter commentadapter = new RestaurantMenuRecyclerAdapter();

        StickyLinearLayoutManager layoutManager = new StickyLinearLayoutManager(this, commentadapter){
            @Override
            public boolean isAutoMeasureEnabled() {
                return true;
            }

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                RecyclerView.SmoothScroller smoothScroller = new TopSmoothScroller(recyclerView.getContext());
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }

            class TopSmoothScroller extends LinearSmoothScroller {

                TopSmoothScroller(Context context) {
                    super(context);
                }

                @Override
                public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
                    return boxStart - viewStart;
                }
            }
        };

        layoutManager.elevateHeaders(5);
        commentsview.setLayoutManager(layoutManager);
        commentsview.setAdapter(commentadapter);

        layoutManager.setStickyHeaderListener(new StickyLinearLayoutManager.StickyHeaderListener() {
            @Override
            public void headerAttached(View headerView, int adapterPosition) {
                Log.d("StickyHeader", "Header Attached : " + adapterPosition);
            }

            @Override
            public void headerDetached(View headerView, int adapterPosition) {
                Log.d("StickyHeader", "Header Detached : " + adapterPosition);
            }
        });

        commentsview.postDelayed(new Runnable() {
            @Override
            public void run() {
                commentadapter.addDataList(genDataList(0));
            }
        },1000);

    }

    public static List<Object> genDataList(int start) {
        List<Object> items = new ArrayList<>();


        items.add(new HeaderItem("Menu " ));
        items.add(new Foods("Alloo", "Rs 600", "This is the best aloo"));
        items.add(new Foods("mo:mo", "Rs 120" , "This is the momo"));
        items.add(new Foods("Pizza", "Rs 600" , "This is the best Pizza"));
        items.add(new Foods("Paratha", "Rs 600" , "This is the best Paratha"));
        items.add(new Foods("Burger", "Rs 500" , "This is the best Burger"));
        items.add(new Foods("mo:mo", "Rs 120" , "This is the momo"));

        
        items.add(new HeaderItem("Comments" ));
        items.add(new Comments("Amanda Raj Shrestha " , "This restaurant sucks  "  ));
        items.add(new Comments("Sunil Thakur" , "I love big black balls"  ));
        items.add(new Comments("Amanda Raj Shrestha " , "This restaurant sucks  "  ));

        items.add(new Comments("Sunil Thakur" , "I love big black balls"  ));
        items.add(new Comments("Amanda Raj Shrestha " , "This restaurant sucks  "  ));
        items.add(new Comments("Sunil Thakur" , "I love big black balls"  ));
        items.add(new Comments("Amanda Raj Shrestha " , "This restaurant sucks  "  ));
        items.add(new Comments("Amanda Raj Shrestha " , "This restaurant sucks  "  ));
        items.add(new Comments("Sunil Thakur" , "I love big black balls"  ));
        items.add(new Comments("Amanda Raj Shrestha " , "This restaurant sucks  "  ));
        return items;
    }
}
