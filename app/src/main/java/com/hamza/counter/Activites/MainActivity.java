package com.hamza.counter.Activites;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.hamza.counter.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int counter = 0, totalCounts = 0;
    TextView countertextview, totalcountsTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countertextview = findViewById(R.id.counterTextview);
        totalcountsTextview = findViewById(R.id.totalcounts);

        setTotalcountsText(getTotalcounts());
    }

    @SuppressLint("SetTextI18n")
    private void setTotalcountsText(int totalcounts) {
        totalcountsTextview.setText("Total counts : " + totalcounts);
    }

    private int getTotalcounts() {
        SharedPreferences preference = getSharedPreferences("PREF", MODE_PRIVATE);
        totalCounts = preference.getInt("counts", 0);
        return totalCounts;
    }

    public void increaseCounterInrelativeLayout(View view) {
        counter++;
        totalCounts++;
        checkCounter();
        saveCounts();
        countertextview.setText(String.valueOf(counter));
    }

    private void saveCounts() {
        SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
        editor.putInt("counts", totalCounts);
        editor.apply();
        setTotalcountsText(totalCounts);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.deleteallcounts:
                deleteAllCounts(item);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void deleteAllCounts(MenuItem item) {
        totalCounts = 0;
        saveCounts();
        Toast.makeText(getApplicationContext(), "All counts deleted !", Toast.LENGTH_SHORT).show();
    }
}