package com.example.mpokedex.ui.listPokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mpokedex.bo.Pokemon
import com.example.mpokedex.bo.Type
import com.example.mpokedex.utils.PokemonService
import kotlinx.coroutines.launch

class ListPokemonViewModel : ViewModel() {

    var listPokemons = MutableLiveData<List<Pokemon>>()



    fun getAllPokemons():MutableLiveData<List<Pokemon>>{
        viewModelScope.launch {
            listPokemons.value = PokemonService.PokemonApi.retrofitService.getAllPokemons()
        }
        return listPokemons
    }
    fun getPokemonByQuery(q:String): MutableLiveData<List<Pokemon>> {
        viewModelScope.launch {
            val buffer = PokemonService.PokemonApi.retrofitService.getAllPokemons()
            val pokemonWithQ = mutableListOf<Pokemon>()
            // pokemons.value
            buffer.forEach { if (it.name.contains(q, ignoreCase = true)){
                pokemonWithQ.add(it)
            }
                listPokemons.value = pokemonWithQ
            }
        }
        return listPokemons
    }
/*
     fun getAllTypes():MutableLiveData<List<Type>>{
         viewModelScope.launch { listTypes.value = PokemonService.PokemonApi.retrofitService.getAllTypes() }
        return listTypes
    }
*/



}