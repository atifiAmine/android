package com.example.ex3

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnOn: ImageButton
    private lateinit var btnOff: ImageButton
    private lateinit var myLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOn = findViewById(R.id.buttonOn)
        btnOff = findViewById(R.id.buttonOff)
        myLayout = findViewById(R.id.myLayout)

        // Action pour le bouton "On"
        btnOn.setOnClickListener {
            myLayout.setBackgroundResource(R.drawable.led_on)  // Change l'arrière-plan en image LED allumée
            val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
            myToast.show()
        }

        // Action pour le bouton "Off"
        btnOff.setOnClickListener {
            myLayout.setBackgroundResource(R.drawable.led_off)  // Change l'arrière-plan en image LED éteinte
            val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
            myToast.show()
        }
    }
}
