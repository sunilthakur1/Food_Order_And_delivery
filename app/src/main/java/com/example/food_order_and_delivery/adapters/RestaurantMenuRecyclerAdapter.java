package com.example.food_order_and_delivery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.food_order_and_delivery.R;
import com.example.food_order_and_delivery.model.Comments;
import com.example.food_order_and_delivery.model.Foods;
import com.example.food_order_and_delivery.model.HeaderItem;
import com.yuyang.stickyheaders.AdapterDataProvider;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenuRecyclerAdapter extends RecyclerView.Adapter<RestaurantMenuRecyclerAdapter.BaseViewHolder> implements AdapterDataProvider {
    private final List<Object> dataList = new ArrayList<>();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch(viewType){
                case 0:
                    return new CommentsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item_view, parent, false));
                case 1:


                    return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_menu_header_view, parent, false));

                case 2:
                    return new FoodHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list, parent, false));


                default:
                     return null;



            }

    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        final Object item = dataList.get(position);
        if (item instanceof Comments) {
            CommentsViewHolder itemViewHolder = (CommentsViewHolder) holder;
            itemViewHolder.nameTextView.setText(((Comments) item).getName());
            itemViewHolder.commentsTextView.setText(((Comments) item).getComment());
        } else if (item instanceof HeaderItem) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.titleTextView.setText(((HeaderItem) item).title);


        }else if(item instanceof Foods){
            FoodHolder foodsholder = (FoodHolder) holder;
            foodsholder.name.setText(((Foods) item) .getFname());
            foodsholder.price.setText(((Foods) item) .getFprice());
            foodsholder.desc.setText(((Foods) item) .getDesc());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(dataList.get(position) instanceof Comments){
            return  0;
        }else if(dataList.get(position) instanceof HeaderItem){
            return 1;
        }else if(dataList.get(position) instanceof Foods){
            return 2;
        }else{
            return 3;
        }
    }

    @Override
    public List<?> getAdapterData() {
        return dataList;
    }

    public void setDataList(List<Object> items) {
        dataList.clear();
        dataList.addAll(items);
        notifyDataSetChanged();
    }

    public void addDataList(List<Object> items) {
        if (items != null) {
            int start = dataList.size();
            dataList.addAll(items);
            notifyItemRangeInserted(start, items.size());
        }
    }
    private static final class FoodHolder extends BaseViewHolder {
        TextView name, price, desc;

         FoodHolder( View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.foodname);
            price = itemView.findViewById(R.id.fprice);
            desc = itemView.findViewById(R.id.fooddesc);
        }
    }
    private static final class CommentsViewHolder extends BaseViewHolder {

        TextView nameTextView;
        TextView commentsTextView;

        CommentsViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.comment_name);
            commentsTextView = itemView.findViewById(R.id.comment_message);
        }
    }

    private static final class HeaderViewHolder extends BaseViewHolder {

        TextView titleTextView;
        TextView button;

        HeaderViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.tv_title);

        }
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
}
