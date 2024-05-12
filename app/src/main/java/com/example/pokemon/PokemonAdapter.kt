package com.example.pokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(private var clickListener: PokemonClickListener) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    private val pokemonList = ArrayList<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position])
        holder.itemView.setOnClickListener {clickListener.onPokemonClick(pokemonList[position])}
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updatePokemonList(newPokemonList: List<Pokemon>) {
        pokemonList.clear()
        pokemonList.addAll(newPokemonList)
        notifyDataSetChanged()
    }
}

