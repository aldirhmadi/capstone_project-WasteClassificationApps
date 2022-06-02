package com.example.wasteclassificationapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Organik(
    var name: String,
    var photo: Int
) : Parcelable
