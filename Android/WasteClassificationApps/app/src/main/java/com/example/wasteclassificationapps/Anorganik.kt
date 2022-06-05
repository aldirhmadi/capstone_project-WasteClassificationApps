package com.example.wasteclassificationapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Anorganik(
    var name: String,
    var photo: Int
) : Parcelable
