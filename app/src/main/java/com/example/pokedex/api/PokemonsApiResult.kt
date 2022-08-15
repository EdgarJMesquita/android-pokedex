package com.example.pokedex.api

import com.example.pokedex.Pokemon

data class PokemonsApiResult(
    val count: Int,
    val preview: String?,
    val next: String?,
    var results: List<PokemonResult>
)

class PokemonResult (
    val name: String,
    val url: String
)


data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonApiType>,
    val preview: String?,
    val next: String?,
)

data class PokemonApiType(
    val slot: Int,
    val type: PokemonTypeSlot
)

data class PokemonTypeSlot(
    val name: String,
    val url: String
)