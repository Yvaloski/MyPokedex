package com.example.mpokedex.utils

import com.example.mpokedex.bo.Pokemon
import com.example.mpokedex.bo.Type
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
        companion object{
            val BASE_URL = "https://pokebuildapi.fr/api/v1/"

            val moshi: Moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .build()
        }
        @GET("pokemon/generation/1")
        suspend fun getAllPokemons():List<Pokemon>

        @GET("pokemon/generation/1/{id}")
        suspend fun getPokemon(@Path("id") id:Int):Pokemon

      /*  @GET("types")
        suspend fun getAllTypes():List<Type>

        @GET("types/{id}")
        suspend fun getTypes(@Path("id") id: Int):Int*/

        object PokemonApi{
            val retrofitService: PokemonService by lazy { retrofit.create(PokemonService::class.java) }
        }

    }
