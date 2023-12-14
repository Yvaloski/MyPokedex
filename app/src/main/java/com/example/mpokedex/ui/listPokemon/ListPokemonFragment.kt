package com.example.mpokedex.ui.listPokemon

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mpokedex.R
import com.example.mpokedex.adapters.PokemonAdapter
import com.example.mpokedex.bo.Pokemon
import com.example.mpokedex.databinding.FragmentListPokemonBinding
import com.squareup.picasso.Picasso

class ListPokemonFragment : Fragment() {
    lateinit var binding: FragmentListPokemonBinding


    private  var vm: ListPokemonViewModel = ListPokemonViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPokemonBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        vm.getAllPokemons().observe(viewLifecycleOwner){
            displayPokemons(it,view)
        }

    }

    private fun displayPokemons(pokemons: List<Pokemon>, view: View) {


        binding.rvPokemonRecycler.adapter = PokemonAdapter(pokemons){
            val direction = ListPokemonFragmentDirections.actionListPokemonFragmentToDetailsFragment(it)
            Navigation.findNavController(view).navigate(direction)
        }

        binding.rvPokemonRecycler.layoutManager = LinearLayoutManager(view.context)

    }
}