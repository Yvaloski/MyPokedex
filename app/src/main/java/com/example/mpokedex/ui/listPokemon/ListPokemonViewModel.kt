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

/*
     fun getAllTypes():MutableLiveData<List<Type>>{
         viewModelScope.launch { listTypes.value = PokemonService.PokemonApi.retrofitService.getAllTypes() }
        return listTypes
    }
*/



}