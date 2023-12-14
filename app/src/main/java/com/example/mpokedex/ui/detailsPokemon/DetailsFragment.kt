package com.example.mpokedex.ui.detailsPokemon

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mpokedex.R
import com.example.mpokedex.databinding.FragmentDetailsBinding
import com.example.mpokedex.databinding.FragmentListPokemonBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {




    val args:DetailsFragmentArgs by navArgs()

    private var vm = DetailsViewModel()
    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemon = args.pokemon
        binding.pokemon= pokemon
        binding.lifecycleOwner=this
        Picasso.get().load(pokemon.image).into(binding.imageView)
        var image = binding.imageView
    }
}