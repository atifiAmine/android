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
import android.widget.ImageView



class MainActivity : AppCompatActivity() {


    private lateinit var Chambre: ToggleButton
    private lateinit var Salon: ToggleButton
    private lateinit var Salledebain: ToggleButton
    private lateinit var Garage: ToggleButton
    private lateinit var chambreImage: ImageView
    private lateinit var salonImage: ImageView
    private lateinit var salledebainImage: ImageView
    private lateinit var garageImage: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Chambre = findViewById(R.id.chambre)
        Salon = findViewById(R.id.salon)
        Salledebain = findViewById(R.id.salledebain)
        Garage = findViewById(R.id.garage)
        chambreImage = findViewById(R.id.chambreimage)
        salonImage = findViewById(R.id.salonimage)
        salledebainImage = findViewById(R.id.salledebainimage)
        garageImage = findViewById(R.id.garageimage)




        Chambre.setOnCheckedChangeListener { _,isChecked ->
            var ledstate = if (isChecked) "on" else "off"
            if (isChecked) {
                chambreImage.setImageResource(R.drawable.vert)
                val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            } else {

                chambreImage.setImageResource(R.drawable.rouge)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            }



        }

        Salon.setOnClickListener {
            if (Salon.isChecked) {
                salonImage.setImageResource(R.drawable.vert)
                val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            } else {

                salonImage.setImageResource(R.drawable.rouge)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            }


        }

        Salledebain.setOnClickListener {
            if (Salledebain.isChecked) {
                salledebainImage.setImageResource(R.drawable.vert)
                val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            } else {

                salledebainImage.setImageResource(R.drawable.rouge)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            }


        }

            Garage.setOnClickListener {
            if (Garage.isChecked) {
                garageImage.setImageResource(R.drawable.vert)
                val myToast = Toast.makeText(this, "Lumière allumée", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            } else {

                garageImage.setImageResource(R.drawable.rouge)// Change l'arrière-plan en bleu
                val myToast = Toast.makeText(this, "Lumière éteinte", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER, 0, 0) // Affiche le toast au centre
                myToast.show()
            }


        }
    }
}
