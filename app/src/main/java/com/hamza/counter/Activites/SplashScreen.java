package com.hamza.counter.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.bumptech.glide.Glide;
import com.hamza.counter.R;

public class SplashScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        ImageView splashImage = findViewById(R.id.splashImage);

        Glide.with(this)
                .load("https://ieee.cs.uowm.gr/wp-content/uploads/2013/01/5f4eafdeb55fe172f71e6ed7_Logo-IEEE-1.jpg")
                .fitCenter()
                .into(splashImage);

        Animation slideInLeft = AnimationUtils.loadAnimation(this, R.anim.anim_slide_in_left);
        splashImage.setAnimation(slideInLeft);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }, 5000);

    }
}
