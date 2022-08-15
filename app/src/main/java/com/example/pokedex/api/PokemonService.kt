package com.example.pokedex.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonService {
    //https://pokeapi.co/api/v2/pokemon?limit=150
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<PokemonApiResult>
}