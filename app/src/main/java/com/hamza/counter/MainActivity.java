package com.hamza.counter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView counterText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.textView);

    }


   //Onclick method form increasing the number by one and change the color every 10 numbers
    public void increaseNumber(View view) {

        String number = counterText.getText().toString();
        int n = Integer.parseInt(number);
        n++;
        String a = Integer.valueOf(n).toString();

        //set the number after increase it by one
        counterText.setText(a);

        //to change the color every 10 Counts
        if (n >= 10 && n <= 19){
            counterText.setTextColor(getResources().getColor(R.color.yallow));
        }
        else if (n >= 20 && n <= 29){
            counterText.setTextColor(getResources().getColor(R.color.red));
        }
        else{
            counterText.setTextColor(getResources().getColor(R.color.black));
        }

    }

    //OnClick method to Reset the counter to Zero
    public void resetNumber (View view){
        //set the counter to Zero
        counterText.setText("0");
    }


}