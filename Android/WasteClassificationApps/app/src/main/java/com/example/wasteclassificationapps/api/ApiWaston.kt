package com.example.wasteclassificationapps.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiWaston {
    @Multipart
    @POST("image")
    fun imageFromApi(
        @Part file:MultipartBody.Part
    ): Call<ResponseImageApi>
}