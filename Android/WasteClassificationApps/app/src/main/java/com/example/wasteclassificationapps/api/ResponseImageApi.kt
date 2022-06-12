package com.example.wasteclassificationapps.api

import com.google.gson.annotations.SerializedName

data class ResponseImageApi (

    @field:SerializedName("desc")
    val desc: String,

    @field:SerializedName("do")
    val does: String,

    @field:SerializedName("dont")
    val dont: String,

    @field:SerializedName("example")
    val example: String,

    @field:SerializedName("impact")
    val impact: String,

    @field:SerializedName("type")
    val type: String,

)