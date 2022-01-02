package com.hamza.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Objects.requireNonNull(getSupportActionBar()).hide();
        TextView tv_appName = findViewById(R.id.splash_tv_appName);
        ImageView iv_logo = findViewById(R.id.splash_iv);

        Glide.with(this)
                .load("https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ")
                .into(iv_logo);

        Animation anim_left = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        tv_appName.setAnimation(anim_left);
        iv_logo.setAnimation(anim_left);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }, 3000);
    }
}