package com.hamza.counter;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String SHARED_NAME = "settings";
    private final String COUNTER_KEY = "counter";
    private TextView tv_counterValue;
    private int counter = 0;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.main_constraint);
        Button btn_reset = findViewById(R.id.main_btn_reset);
        tv_counterValue = findViewById(R.id.main_tv_counterValue);

        sharedPreferences = this.getSharedPreferences(SHARED_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        constraintLayout.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int color;
        switch (v.getId()) {
            case R.id.main_constraint:
                tv_counterValue.setText(String.valueOf(++counter));
                if (counter % 10 == 0) {
                    color = (tv_counterValue.getCurrentTextColor() ==
                            getResources().getColor(R.color.black)) ?
                            getResources().getColor(R.color.teal_200) :
                            getResources().getColor(R.color.black);
                    tv_counterValue.setTextColor(color);
                }
                break;

            case R.id.main_btn_reset:
                counter = 0;
                tv_counterValue.setText(String.valueOf(counter));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_counterValue.setText(sharedPreferences.getString(COUNTER_KEY, "0"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor.putString(COUNTER_KEY, String.valueOf(counter)).apply();
    }
}