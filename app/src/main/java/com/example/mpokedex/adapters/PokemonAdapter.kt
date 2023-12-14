package com.example.mpokedex.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.RecyclerView
import com.example.mpokedex.bo.Pokemon
import com.example.mpokedex.databinding.ItemPokemonLineBinding
import com.squareup.picasso.Picasso

class PokemonAdapter(val pokemonList: List<Pokemon>
, val listener:(pokemon:Pokemon)->Unit):RecyclerView.Adapter<PokemonAdapter.PokemonVH>() {



    class PokemonVH(val binding: ItemPokemonLineBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {

        val binding= ItemPokemonLineBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
            )

        return  PokemonVH(binding)
    }

    override fun getItemCount()=pokemonList.size


    override fun onBindViewHolder(holder: PokemonVH, position: Int) {

        val currentPokemon = pokemonList[position]

        holder.binding.pokemon = currentPokemon

        Picasso.get().load(currentPokemon.image).into(holder.binding.imageView2)
        // Afficher le nom des types dans le champ de texte tvPokemonHp
        holder.binding.tvPokemonHp.text = currentPokemon.getApiTypesAsString()

        holder.itemView.setOnClickListener {

            listener.invoke(pokemonList[position])
        }

    }


}