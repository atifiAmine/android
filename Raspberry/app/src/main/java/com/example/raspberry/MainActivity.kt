package com.example.raspberry

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
=======
import com.example.raspberry.R
import android.graphics.Color
import android.widget.ImageView

>>>>>>> d7796696a0b6280499c45a89b2d6a71e4247f6d6

class MainActivity : AppCompatActivity() {

    private lateinit var Chambre: ToggleButton
    private lateinit var Salon: ToggleButton
    private lateinit var Salledebain: ToggleButton
    private lateinit var Garage: ToggleButton
    private lateinit var chambreImage: ImageView
    private lateinit var salonImage: ImageView
    private lateinit var salledebainImage: ImageView
    private lateinit var garageImage: ImageView
    private lateinit var apiService: ApiService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des vues
        Chambre = findViewById(R.id.chambre)
        Salon = findViewById(R.id.salon)
        Salledebain = findViewById(R.id.salledebain)
        Garage = findViewById(R.id.garage)
        chambreImage = findViewById(R.id.chambreimage)
        salonImage = findViewById(R.id.salonimage)
        salledebainImage = findViewById(R.id.salledebainimage)
        garageImage = findViewById(R.id.garageimage)

<<<<<<< HEAD
        // Configuration de Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://67a59a64-6711-4258-a10f-363a62e3a180.mock.pstmn.io/") // URL de ton serveur mock
            .addConverterFactory(GsonConverterFactory.create())
            .build()
=======
>>>>>>> d7796696a0b6280499c45a89b2d6a71e4247f6d6


        // Initialisation des écouteurs
        setupListeners()
    }

<<<<<<< HEAD
    // Fonction pour initialiser les écouteurs de tous les boutons
    private fun setupListeners() {
        // Écouteur pour le ToggleButton Chambre
        Chambre.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            chambreImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            controlLight("chambre", ledstate)
=======
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



>>>>>>> d7796696a0b6280499c45a89b2d6a71e4247f6d6
        }

        // Écouteur pour le ToggleButton Salon
        Salon.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            salonImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            controlLight("salon", ledstate)
        }

        // Écouteur pour le ToggleButton Salle de Bain
        Salledebain.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            salledebainImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            val message = if (isChecked) "Lumière allumée" else "Lumière éteinte"
            showToast(message)
            controlLight("salledebain", ledstate)
        }

        // Écouteur pour le ToggleButton Garage
        Garage.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            garageImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            val message = if (isChecked) "Lumière allumée" else "Lumière éteinte"
            showToast(message)
            controlLight("garage", ledstate)
        }
    }

    // Fonction pour envoyer la requête à l'API et allumer/éteindre la lumière
    private fun controlLight(room: String, ledState: String) {
        apiService.controlLight(room, ledState).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("MainActivity", "Requête réussie : $room -> $ledState")
                } else {
                    Log.e("MainActivity", "Erreur de serveur")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("MainActivity", "Erreur de requête : ${t.message}")
            }
        })
    }

    // Fonction pour afficher un Toast au centre de l'écran
    private fun showToast(message: String) {
        val myToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.CENTER, 0, 0)
        myToast.show()
    }
}
