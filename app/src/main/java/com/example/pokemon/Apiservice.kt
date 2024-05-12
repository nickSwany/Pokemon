package com.example.pokemon

import retrofit2.http.GET
import retrofit2.http.Path

interface Apiservice {
    @GET("pokemon/{id}")
    suspend fun getInformationPokemon(
        @Path("id") id: Int,
    ) : Pokemon
}