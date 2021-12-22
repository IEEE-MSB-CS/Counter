package com.hamza.counter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView countertextview;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countertextview = findViewById(R.id.counterTextview);
    }

    public void increaseCounterInrelativeLayout(View view) {
        counter++;
        checkCounter();
        countertextview.setText(String.valueOf(counter));
    }

    private void checkCounter() {
        if (counter % 10 == 0)
            countertextview.setTextColor(getRandomcolor());

    }

    private int getRandomcolor() {
        int[] colors = {Color.BLUE, Color.RED, Color.YELLOW};
        int random = new Random().nextInt(colors.length);
        return colors[random];
    }


    public void resetCounter(View view) {
        counter = 0;
        countertextview.setText(String.valueOf(counter));
        countertextview.setTextColor(Color.BLACK);
    }
}