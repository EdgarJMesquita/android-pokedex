package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemonsList.layoutManager = LinearLayoutManager(this)

        val type = PokemonType("Fogo", "fogo")

        val charmander = Pokemon(
            4,
            "Charmander",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            listOf<PokemonType>(type)
        )
        val squirtle = Pokemon(
             7,
            "Squirtle",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
            listOf<PokemonType>(type)
        )


        rvPokemonsList.adapter = PokemonListAdapter(listOf(charmander,squirtle))

    }
}