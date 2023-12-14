package com.example.mpokedex.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(
    var HP:Int,
    var attack:Int,
    var defense:Int,
    var special_attack:Int,
    var special_defense:Int,
    var speed:Int,

):Parcelable
