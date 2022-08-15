package com.example.pokedex

import com.example.pokedex.api.PokemonTypeSlot

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
) {
    val formattedNumber = id.toString().padStart(3, '0')
    val imageURL = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}