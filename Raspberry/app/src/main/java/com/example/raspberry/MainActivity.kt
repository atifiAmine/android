package com.example.raspberry

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.raspberry.R
import android.graphics.Color


class MainActivity : AppCompatActivity() {


    private lateinit var Chambre: ToggleButton
    private lateinit var myLayout: FrameLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Chambre = findViewById(R.id.chambre)


        Chambre.setOnClickListener {
            if (Chambre.isChecked) {
                myLayout.setBackgroundResource(R.drawable.vert)
                val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            } else {

                Chambre.setBackgroundColor(Color.RED)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            }


        }
    }
}
