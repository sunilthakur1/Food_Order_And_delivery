package com.example.food_order_and_delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_order_and_delivery.R;
import com.example.food_order_and_delivery.model.Liquors;

import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchHolder> {
    private List<Liquors> liquorlist;
    private Context context;

    public SearchListAdapter(Context context, List<Liquors> liquorlist){
        this.context = context;
        this.liquorlist = liquorlist;
    }

    @NonNull
    @Override
    public SearchListAdapter.SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
         view = inflater.inflate(R.layout.liquor_list, null);
         SearchListAdapter.SearchHolder holder = new SearchListAdapter.SearchHolder(view);
         return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapter.SearchHolder holder, int position) {
          Liquors liquors = liquorlist.get(position);
          holder.liqname.setText(liquors.getLiqname());
        holder.liqprice.setText(liquors.getLprice());
        holder.liqdesc.setText(liquors.getDescrip());



    }

    @Override
    public int getItemCount() {return liquorlist.size();}

    public class SearchHolder extends RecyclerView.ViewHolder {
        TextView liqname, liqprice, liqdesc;

        public SearchHolder(@NonNull View itemView) {
            super(itemView);
            liqname = itemView.findViewById(R.id.liquorname);
            liqprice = itemView.findViewById(R.id.liqprice);
            liqdesc = itemView.findViewById(R.id.liqdesc);
        }
    }
}
