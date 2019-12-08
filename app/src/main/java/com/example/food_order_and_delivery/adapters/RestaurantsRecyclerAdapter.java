package com.example.food_order_and_delivery.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_order_and_delivery.FoodListActivity;
import com.example.food_order_and_delivery.R;
import com.example.food_order_and_delivery.model.Restaurants;

import java.util.List;

public class RestaurantsRecyclerAdapter extends RecyclerView.Adapter<RestaurantsRecyclerAdapter.RestaurantsHolder> {

    private List<Restaurants> restList;
    private Context context;


    public RestaurantsRecyclerAdapter(Context context, List<Restaurants> restList){
        this.context = context;
        this.restList = restList;
    }
    @NonNull
    @Override
    public RestaurantsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.toprestaurants_layout, parent,false);
        RestaurantsHolder holder = new RestaurantsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsHolder holder, int position) {
    final Restaurants restaurants = restList.get(position);
    holder.restimg.setImageResource(restaurants.getImg());
    holder.restlocation.setText(restaurants.getLocation());
    holder.restname.setText(restaurants.getName());

    holder.restimg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            context.startActivity(new Intent(context, FoodListActivity.class));
        }
    });
    }

    @Override
    public int getItemCount() {
        return restList.size();
    }
    public class RestaurantsHolder extends RecyclerView.ViewHolder{
        ImageView restimg;
        TextView restname, restlocation;

        public RestaurantsHolder(View view){
            super(view);

            restimg = view.findViewById(R.id.toprestimg);
            restname = view.findViewById(R.id.toprestname);
            restlocation = view.findViewById(R.id.toprestlocat);
        }

    }
}
