package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.api.PokemonRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(Runnable {
            loadPokemons()
        }).start()
    }

    fun loadPokemons() {
        val pokemonApiResult = PokemonRepository.listPokemons()

        pokemonApiResult?.results?.let {
            val pokemons: List<Pokemon?> = it.map {pokemon->
                val id = pokemon.url.replace("https://pokeapi.co/api/v2/pokemon/","").replace("/","");

                val pokemonApiResult = PokemonRepository.getPokemon(id.toInt());

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map {type->
                           type.type
                        }
                    )
                }
            }



            rvPokemonsList.post {
                rvPokemonsList.layoutManager = LinearLayoutManager(this)
                rvPokemonsList.adapter = PokemonListAdapter(pokemons)
            }
        };

    }
}