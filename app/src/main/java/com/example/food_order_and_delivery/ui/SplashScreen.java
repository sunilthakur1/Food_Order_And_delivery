package com.example.food_order_and_delivery.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.food_order_and_delivery.MainActivity;
import com.example.food_order_and_delivery.R;

public class SplashScreen extends AppCompatActivity {

    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imgview = findViewById(R.id.logo);

        Animation anime = AnimationUtils.loadAnimation(this,R.anim.duration);
        imgview.startAnimation(anime);

        final Intent intent = new Intent(this, MainActivity.class);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(1500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
