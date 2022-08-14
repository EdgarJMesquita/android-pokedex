package com.example.pokedex

data class Pokemon(
    val id: Int,
    val name: String,
    val image: String,
    val types: List<PokemonType>
){
    val formattedNumber = id.toString().padStart(3, '0')
}