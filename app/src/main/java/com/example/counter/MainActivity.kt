package com.example.counter

import android.graphics.Color
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var counter = 0
    var change = 1
    val list = listOf<Int>(Color.RED,Color.BLUE,Color.CYAN,Color.YELLOW)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraint.setOnClickListener {
            ++counter
            textView.text = counter.toString()
            if (counter == change*10){
                change++
                Collections.shuffle(list)
                textView.setTextColor(list[0])
            }
        }

        resetBtn.setOnClickListener {
            counter = 0
            textView.text = counter.toString()
        }

    }
}