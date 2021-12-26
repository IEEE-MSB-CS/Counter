package com.hamza.counter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView countertextview;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countertextview = findViewById(R.id.counterTextview);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        counter = prefs.getInt("key", 0);
        countertextview.setText(String.valueOf(counter));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Reset:
                resetCounter();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void increaseCounterInrelativeLayout(View view) {
        counter++;
        checkCounter();
        countertextview.setText(String.valueOf(counter));

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("key", counter);
        editor.commit();
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

    private void resetCounter() {
        counter = 0;
        countertextview.setText(String.valueOf(counter));
        countertextview.setTextColor(Color.BLACK);
    }

    /*public void resetCounter(View view) {
        counter = 0;
        countertextview.setText(String.valueOf(counter));
        countertextview.setTextColor(Color.BLACK);
    }*/
}