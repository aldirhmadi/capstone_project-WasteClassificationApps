package com.example.wasteclassificationapps.api

import com.example.wasteclassificationapps.model.ModelWasteImage
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiWaston {

    @POST("image")
    fun imageFromApi(
        @Body wasteImage: ModelWasteImage
    ): Call<ResponseImageApi>

}