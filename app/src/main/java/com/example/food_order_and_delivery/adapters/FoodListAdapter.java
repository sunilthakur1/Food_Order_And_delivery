package com.example.food_order_and_delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_order_and_delivery.R;
import com.example.food_order_and_delivery.model.Foods;
import com.example.food_order_and_delivery.model.Restaurants;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodHolder> {

    private List<Foods> foodsList;
    private Context context;

    public FoodListAdapter(Context context, List<Foods> foodsList){
        this.context = context;
        this.foodsList = foodsList;
    }
    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.food_list, parent,false);
        FoodHolder holder = new FoodHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
         Foods foods = foodsList.get(position);
         holder.name.setText(foods.getFname());
         holder.price.setText(foods.getFprice());
         holder.desc.setText(foods.getDesc());

    }

    @Override
    public int getItemCount(){return foodsList.size();}


        public class FoodHolder extends RecyclerView.ViewHolder {
            TextView name, price, desc;

            public FoodHolder( View itemView) {
                super(itemView);

                name = itemView.findViewById(R.id.foodname);
                price = itemView.findViewById(R.id.fprice);
                desc = itemView.findViewById(R.id.fooddesc);
            }
        }
    }

