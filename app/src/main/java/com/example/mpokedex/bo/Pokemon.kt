package com.example.mpokedex.bo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int,
    var pokedexId:Int,
    var name:String,
    var image:String,
    var stats: Stats,
    var apiTypes:Array<Type>,

):Parcelable{

    fun getApiTypesAsString(): String {
        return apiTypes.joinToString(", ") { it.name }    }


}
