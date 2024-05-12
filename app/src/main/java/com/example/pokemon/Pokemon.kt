package com.example.pokemon

data class Pokemon(
    val base_experience: Int,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int, //хоть это не возраст, но ради тестового и большего описания, сегдня это будет возрастом
    val sprites: Sprites,
    val weight: Int
)

data class Sprites(
    val front_default: String
)