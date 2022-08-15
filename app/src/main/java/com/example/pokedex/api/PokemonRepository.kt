package com.example.pokedex.api

import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    // https://pokeapi.co/api/v2/pokemon?limit=150
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body();
    }

    fun getPokemon(id: Int): PokemonApiResult? {
        val call = service.getPokemon(id)
        return call.execute().body()
    }


}