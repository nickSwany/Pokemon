package com.example.pokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pokemon.MainActivity.Companion.EXTRA_EXPERIENCE
import com.example.pokemon.MainActivity.Companion.EXTRA_HEIGHT
import com.example.pokemon.MainActivity.Companion.EXTRA_IMAGE
import com.example.pokemon.MainActivity.Companion.EXTRA_NAME
import com.example.pokemon.MainActivity.Companion.EXTRA_ORDER
import com.example.pokemon.MainActivity.Companion.EXTRA_WEIGHT
import com.example.pokemon.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonAge = intent.getIntExtra(EXTRA_ORDER, 0)

        binding.apply {
            tvNamePokemon.text = intent.getStringExtra(EXTRA_NAME)!!.capitalize()
            weightNumber.text = intent.getIntExtra(EXTRA_WEIGHT, 0).toString()
            heightNumber.text = intent.getIntExtra(EXTRA_HEIGHT,0).toString()
            orderNumber.text = pokemonAge.toString()
            experienceNumber.text = intent.getIntExtra(EXTRA_EXPERIENCE,0).toString()
            year.text = getAgeText(pokemonAge)

            btBack.setOnClickListener {
                finish()
            }
        }

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_IMAGE))
            .into(binding.imageView)
    }

     private fun getAgeText(order: Int) : String {
         return when {
             order % 10 == 1 && order % 100 != 11 -> "год"
             order % 10 in 2..4 && (order % 100 < 10 || order % 100 >= 20) -> "года"
             else -> "лет"
         }
     }
}