package com.hamza.counter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView countertextview , topScoreNumber ;
    int counter , topScore;
    Context context;
    Resources resources;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countertextview = findViewById(R.id.counterTextview);
        topScoreNumber = findViewById(R.id.topScoreNumber);


        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        topScore = prefs.getInt("key", 0);
        topScoreNumber.setText(String.valueOf(topScore));

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
            case R.id.resetTopScore:
                resetTopScore();
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

        if(counter > topScore){
            editor.putInt("key", counter);
            editor.commit();
        }


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


    public void resetTopScore() {
       topScore = 0;
       topScoreNumber.setText(String.valueOf(topScore));

        Toast.makeText(this, "Your Top Score Has Been Reset", Toast.LENGTH_SHORT).show();

    }

    public void resetCounter(View view) {
        counter = 0;
        countertextview.setText(String.valueOf(counter));
        countertextview.setTextColor(Color.BLACK);
    }
}