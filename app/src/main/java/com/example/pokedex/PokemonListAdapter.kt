package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_card.view.*

class PokemonListAdapter(
    val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    class ViewHolder (viewItem: View):RecyclerView.ViewHolder(viewItem)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]


        holder.itemView.apply {
            tvNumber.text = "N° ${currentItem.formattedNumber}"
            tvName.text = currentItem.name
            tvType1.text = currentItem.types[0].name

            if(currentItem.types.size > 1){
                tvType2.text = currentItem.types[1].name
                tvType2.visibility =View.VISIBLE
            } else {
                tvType2.visibility =View.GONE
            }
        }
    }

    override fun getItemCount() = items.size
}