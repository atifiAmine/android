package com.example.raspberry

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Définir l'endpoint de ton API
    @GET("index.php")
    fun controlLight(
        @Query("room") room: String,       // Paramètre pour la pièce
        @Query("led") ledState: String     // Paramètre pour l'état de la lumière (on/off)
    ): Call<Void> // La réponse sera vide, mais tu peux la personnaliser selon ce que ton API renvoie
}
