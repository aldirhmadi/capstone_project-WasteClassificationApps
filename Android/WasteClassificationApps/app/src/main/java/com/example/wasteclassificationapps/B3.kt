package com.example.wasteclassificationapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class B3(
    var name: String,
    var photo: Int
) : Parcelable
