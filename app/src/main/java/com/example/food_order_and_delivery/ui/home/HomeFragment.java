package com.example.food_order_and_delivery.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.food_order_and_delivery.NavigationDrawer;
import com.example.food_order_and_delivery.adapters.ImageAdapter;
import com.example.food_order_and_delivery.R;
import com.example.food_order_and_delivery.adapters.RestaurantsRecyclerAdapter;
import com.example.food_order_and_delivery.model.Restaurants;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private List<Restaurants> restlist = new ArrayList<>();
    private HomeViewModel homeViewModel;
    private ViewPager viewPager;
    private RecyclerView recyclerView;

    private int[] mImageIds = new int[] {R.drawable.cokeandmomo, R.drawable.momo, R.drawable.burger, R.drawable.pizza};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

         viewPager = root.findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(root.getContext(), mImageIds);
        viewPager.setAdapter(adapter);
        recyclerView = root.findViewById(R.id.toprestview);

        restlist.add(new Restaurants("Momotaro", "Thamel","98038383938", R.drawable.chowmein));
        restlist.add(new Restaurants("Bajekosekuwa", "Sinamangal","327209375", R.drawable.pizza));
        restlist.add(new Restaurants("Burgers point", "Dillibazar","6757587548648", R.drawable.burger));


        RestaurantsRecyclerAdapter restaurantsRecyclerAdapter = new RestaurantsRecyclerAdapter(root.getContext(), restlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(),LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(restaurantsRecyclerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 3000);
        return root;

    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            if(getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < mImageIds.length - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}