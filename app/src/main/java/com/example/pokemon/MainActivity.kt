package com.example.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemon.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "pokemon_name"
        const val EXTRA_IMAGE = "pokemon_image"
        const val EXTRA_WEIGHT = "pokemon_weight"
        const val EXTRA_HEIGHT = "pokemon_height"
        const val EXTRA_ORDER = "pokemon_order"
        const val EXTRA_EXPERIENCE = "pokemon_experience"
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: PokemonAdapter

    private var count: Int = 0

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(Apiservice::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            showContent(count)
        }

        binding.btMinus20.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                count = if (count == 0) {
                    0
                } else {
                    count - 10
                }
                showContent(count)
            }
        }

        binding.btPlus20.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                count += 10
                showContent(count)

            }
        }

        val layoutManager = GridLayoutManager(this, 2)
        binding.rcPokemon.layoutManager = layoutManager

        adapter = PokemonAdapter {
            openInformation(it)
        }
        binding.rcPokemon.adapter = adapter
    }

    private suspend fun showContent(number: Int) {
        val pokemonList = mutableListOf<Pokemon>()
        for (i in 1..10) {
            val model = api.getInformationPokemon(number + i)
            pokemonList.add(model)
        }
        adapter.updatePokemonList(pokemonList)
        binding.rcPokemon.adapter = adapter
    }

    private fun openInformation(pokemon: Pokemon) {
        val intent = Intent(this, InformationActivity::class.java).apply {
            putExtra(EXTRA_NAME, pokemon.name)
            putExtra(EXTRA_IMAGE, pokemon.sprites.front_default)
            putExtra(EXTRA_ORDER, pokemon.order)
            putExtra(EXTRA_HEIGHT, pokemon.height)
            putExtra(EXTRA_WEIGHT, pokemon.weight)
            putExtra(EXTRA_EXPERIENCE, pokemon.base_experience)
        }
        startActivity(intent)
    }
}
