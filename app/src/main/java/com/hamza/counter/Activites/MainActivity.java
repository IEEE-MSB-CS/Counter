package com.hamza.counter.Activites;

import android.annotation.SuppressLint;
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

import com.hamza.counter.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView counterTextView , topScoreTextView ;
    int counter = 0 , topScore = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextview);
        topScoreTextView = findViewById(R.id.topScoreNumber);

        setTopScoreText(getTopScore());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
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
        topScore++;
        checkCounter();
        saveCounts();
        counterTextView.setText(String.valueOf(counter));
    }

    private void checkCounter() {
        if (counter % 10 == 0)
            counterTextView.setTextColor(getRandomColor());
    }

    private int getRandomColor() {
        int[] colors = {Color.BLUE, Color.RED, Color.YELLOW};
        int random = new Random().nextInt(colors.length);
        return colors[random];
    }

    public void saveCounts() {
        SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
        editor.putInt("counter", topScore);
        editor.apply();
        setTopScoreText(topScore);
    }

    public void resetCounter(View view) {
        counter = 0;
        counterTextView.setText(String.valueOf(counter));
        counterTextView.setTextColor(Color.BLACK);
    }

    @SuppressLint("SetTextI18n")
    public void setTopScoreText(int topScoreNumber) {
        topScoreTextView.setText("Top Score :" + topScoreNumber);
    }

    public int getTopScore() {
        SharedPreferences preference = getSharedPreferences("PREF", MODE_PRIVATE);
        topScore = preference.getInt("counts", 0);
        return topScore;
    }


    public void resetTopScore() {
       topScore = 0;
       saveCounts();
       Toast.makeText(this, "Your Top Score Has Been Reset", Toast.LENGTH_SHORT).show();

    }






}