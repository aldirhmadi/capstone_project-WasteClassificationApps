package com.example.wasteclassificationapps.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiWaston {
    @Multipart
    @POST("/")
    fun imageFromApi(@Part image:MultipartBody.Part
    ): Call<ResponseImageApi>
}