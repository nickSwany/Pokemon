package com.example.pokemon

data class Pokemon(
    val base_experience: Int,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val weight: Int
)

data class Sprites(
    val front_default: String
)