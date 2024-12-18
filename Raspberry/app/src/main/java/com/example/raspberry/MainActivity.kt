package com.example.raspberry

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

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



        // Configuration de Retrofit



        // Initialisation des écouteurs
        setupListeners()
    }

    // Fonction pour initialiser les écouteurs de tous les boutons
    private fun setupListeners() {
        // Écouteur pour le ToggleButton Chambre
        Chambre.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            chambreImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            sendHttpRequest("chambre", ledstate)
        }

        // Écouteur pour le ToggleButton Salon
        Salon.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            salonImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            sendHttpRequest("salon", ledstate)
        }

        // Écouteur pour le ToggleButton Salle de Bain
        Salledebain.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            salledebainImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            val message = if (isChecked) "Lumière allumée" else "Lumière éteinte"
            sendHttpRequest("salledebain", ledstate)
            showToast(message)

        }

        // Écouteur pour le ToggleButton Garage
        Garage.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            garageImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            val message = if (isChecked) "Lumière allumée" else "Lumière éteinte"
            sendHttpRequest("garage", ledstate)
            showToast(message)

        }
    }
    private fun sendHttpRequest(room: String, ledState: String) {
        // Construire l'URL dynamique avec les paramètres room et led
        val urlString =
            "https://67a59a64-6711-4258-a10f-363a62e3a180.mock.pstmn.io/led?room=$room&led=$ledState"
        thread {
            try {
                // Créer une URL à partir de la chaîne de caractères
                val url = URL(urlString)

                // Ouvrir une connexion HTTP
                val connection = url.openConnection() as HttpURLConnection

                // Configurer la méthode de la requête (GET)
                connection.requestMethod = "GET"
                connection.connectTimeout = 5000
                connection.readTimeout = 5000

                // Lire la réponse du serveur
                val responseCode = connection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Si la requête a réussi, lire la réponse
                    val inputStream = connection.inputStream
                    val reader = InputStreamReader(inputStream)
                    val response = reader.readText()

                    // Log la réponse pour le débogage
                    Log.d("HttpRequest", "Réponse: $response")
                } else {
                    // Si la requête échoue, log l'erreur
                    Log.e("HttpRequest", "Erreur de requête, code : $responseCode")
                }

                connection.disconnect()
            } catch (e: Exception) {
                // Gérer les erreurs
                Log.e("HttpRequest", "Erreur : ${e.message}")
            }
        }
    }



    // Fonction pour afficher un Toast au centre de l'écran
    private fun showToast(message: String) {
        val myToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.CENTER, 0, 0)
        myToast.show()
    }
}
