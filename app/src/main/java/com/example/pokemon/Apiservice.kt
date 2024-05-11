package com.example.pokemon

import android.widget.EditText
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiservice {

    @GET("")
    suspend fun searchPokemon(@Query("") text: String) : PokemonSearchResponce
}