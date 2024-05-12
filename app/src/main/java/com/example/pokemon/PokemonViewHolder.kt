package com.example.pokemon

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemon.databinding.PokemonItemBinding

class PokemonViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = PokemonItemBinding.bind(parent)

    fun bind(pokemon: Pokemon) = with(binding) {

        Glide.with(itemView)
            .load(pokemon.sprites.front_default)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .into(binding.imgPokemon)

        binding.namePokemon.text = pokemon.name.capitalize()
    }
}