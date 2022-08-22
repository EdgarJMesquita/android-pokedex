package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.api.PokemonRepository
import com.example.pokedex.viewModel.PokemonViewModel
import com.example.pokedex.viewModel.PokemonViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory()).get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })

    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) =
        rvPokemonsList.post {
            rvPokemonsList.layoutManager = LinearLayoutManager(this)
            rvPokemonsList.adapter = PokemonListAdapter(pokemons)
        }

}