package com.example.mpokedex.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type(
    var name: String,
    var image: String,


    ):Parcelable
