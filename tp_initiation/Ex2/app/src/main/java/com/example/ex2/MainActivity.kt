package com.example.ex2

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnRouge: Button
    private lateinit var btnVert: Button
    private lateinit var btnBleu: Button
    private lateinit var myLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        // Initialisation des boutons et du FrameLayout
        btnBleu = findViewById(R.id.buttonBleu)
        btnVert = findViewById(R.id.buttonVert)
        btnRouge = findViewById(R.id.buttonRouge)
        myLayout = findViewById(R.id.myLayout)

        // Actions des boutons
        btnBleu.setOnClickListener {
            myLayout.setBackgroundResource(R.drawable.android_blue)  // Change l'arrière-plan en bleu
            val myToast = Toast.makeText(this, "Il fait bleu", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
            myToast.show()
        }

        btnVert.setOnClickListener {
            myLayout.setBackgroundResource(R.drawable.android_green)  // Change l'arrière-plan en vert
            val myToast = Toast.makeText(this, "Il fait vert", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
            myToast.show()
        }

        btnRouge.setOnClickListener {
            myLayout.setBackgroundResource(R.drawable.android_red)  // Change l'arrière-plan en rouge
            val myToast = Toast.makeText(this, "Il fait rouge", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
            myToast.show()
        }
    }
}
