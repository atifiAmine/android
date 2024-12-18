package com.example.calculatrice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatrice.R




class MainActivity : AppCompatActivity() {


    private lateinit var egal : Button
    private lateinit var un : Button
    private lateinit var deux : Button
    private lateinit var trois : Button
    private lateinit var plus : Button
    private lateinit var myLayout: FrameLayout
    private var currentInput: String = ""
    private lateinit var tvMain: TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvMain = findViewById(R.id.TV)
        un = findViewById(R.id.Un)
        deux = findViewById(R.id.Deux)
        trois = findViewById(R.id.Trois)
        plus = findViewById(R.id.Plus)
        egal = findViewById(R.id.Egal)
        myLayout = findViewById(R.id.myLayout)
        

        un.setOnClickListener{
            currentInput += '1'
            tvMain.text = currentInput

        }

        plus.setOnClickListener{
            currentInput += '+'
            tvMain.text = currentInput

        }

        egal.setOnClickListener{
            tvMain.text = tvMain.text

        }

    }



    }


