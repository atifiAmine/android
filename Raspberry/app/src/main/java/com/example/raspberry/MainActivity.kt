package com.example.raspberry

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

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
            sendHttpRequestWithOkHttp("chambre", ledstate)
        }

        // Écouteur pour le ToggleButton Salon
        Salon.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            salonImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            sendHttpRequestWithOkHttp("salon", ledstate)
        }

        // Écouteur pour le ToggleButton Salle de Bain
        Salledebain.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            salledebainImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            val message = if (isChecked) "Lumière allumée" else "Lumière éteinte"
            sendHttpRequestWithOkHttp("salledebain", ledstate)
            showToast(message)

        }

        // Écouteur pour le ToggleButton Garage
        Garage.setOnCheckedChangeListener { _, isChecked ->
            val ledstate = if (isChecked) "on" else "off"
            garageImage.setImageResource(if (isChecked) R.drawable.vert else R.drawable.rouge)
            val message = if (isChecked) "Lumière allumée" else "Lumière éteinte"
            sendHttpRequestWithOkHttp("garage", ledstate)
            showToast(message)

        }
    }



    private fun sendHttpRequestWithOkHttp(room: String, ledState: String) {
        val urlString = "http://172.16.16.8:1880/led?room=$room&led=$ledState"
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(urlString)
            .build()

        // Exécuter la requête dans un thread en arrière-plan
        thread {
            try {
                val response: Response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    Log.d("HttpRequest", "Requête réussie: ${response.body?.string()}")
                } else {
                    Log.e("HttpRequest", "Erreur de requête: ${response.code}")
                }
            } catch (e: Exception) {
                Log.e("HttpRequest", "Erreur lors de l'envoi de la requête: ${e.message}")
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



    // Fonction pour afficher un Toast au centre de l'écran
