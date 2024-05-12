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

        binding.apply {
            tvNamePokemon.text = intent.getStringExtra(EXTRA_NAME)!!.capitalize()
            weightNumber.text = intent.getIntExtra(EXTRA_WEIGHT, 0).toString()
            heightNumber.text = intent.getIntExtra(EXTRA_HEIGHT,0).toString()
            orderNumber.text = intent.getIntExtra(EXTRA_ORDER,0).toString()
            experienceNumber.text = intent.getIntExtra(EXTRA_EXPERIENCE,0).toString()

            btBack.setOnClickListener {
                finish()
            }
        }

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_IMAGE))
            .into(binding.imageView)
    }
}