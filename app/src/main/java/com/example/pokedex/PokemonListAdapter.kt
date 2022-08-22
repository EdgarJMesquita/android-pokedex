package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pokemon_card.view.*

class PokemonListAdapter(
    val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    class ViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        fun bindView(item: Pokemon?, holder: ViewHolder){
            item?.let {
                holder.itemView.apply {
                    Glide.with(itemView.context).load(it.imageURL).into(imgPokemon)
                    tvNumber.text = "N° ${item.formattedNumber}"
                    tvName.text = item.name.capitalize()
                    tvType1.text = item.types[0].name.capitalize()
                    if (item.types.size > 1) {
                        tvType2.text = item.types[1].name.capitalize()
                        tvType2.visibility = View.VISIBLE
                    } else {
                        tvType2.visibility = View.GONE
                    }
                }
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bindView(currentItem, holder)
    }

    override fun getItemCount() = items.size
}