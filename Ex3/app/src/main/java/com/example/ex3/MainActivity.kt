package com.example.ex3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var toggleButton: ToggleButton
    private lateinit var myLayout: FrameLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toggleButton = findViewById(R.id.ToggleButton)
        myLayout = findViewById(R.id.myLayout)

        toggleButton.setOnClickListener {
            if (toggleButton.isChecked) {
                myLayout.setBackgroundResource(R.drawable.led_on)
                toggleButton.setBackgroundResource(R.drawable.toggle_off)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            } else {
                myLayout.setBackgroundResource(R.drawable.led_off)
                toggleButton.setBackgroundResource(R.drawable.toggle_on)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            }


        }
    }
}
