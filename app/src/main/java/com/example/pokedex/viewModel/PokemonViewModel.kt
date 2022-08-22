package com.example.pokedex.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.Pokemon
import com.example.pokedex.api.PokemonRepository

class PokemonViewModel: ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()

    init {
        Thread(Runnable {
            loadPokemons()
        }).start()
    }

    fun loadPokemons() {
        val pokemonApiResult = PokemonRepository.listPokemons()

        pokemonApiResult?.results?.let {
            pokemons.postValue(it.map {pokemon->
                val id = pokemon.url.replace("https://pokeapi.co/api/v2/pokemon/","").replace("/","");

                val pokemonApiResult = PokemonRepository.getPokemon(id.toInt());

                pokemonApiResult?.let {it->
                    Pokemon(
                        it.id,
                        it.name,
                        it.types.map {type->
                            type.type
                        }
                    )
                }
            })
        };

    }
}