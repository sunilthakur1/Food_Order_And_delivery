package com.example.food_order_and_delivery.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.food_order_and_delivery.R;

import java.lang.reflect.Array;

public class ImageAdapter extends PagerAdapter {

    private Context mcontext;
    private int[] mImageIds;

    public ImageAdapter(Context context, int [] mImageIds){
        mcontext = context;
        this.mImageIds = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageview = new ImageView(mcontext);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(mImageIds[position]);
        container.addView(imageview, 0);
        return imageview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }


}
