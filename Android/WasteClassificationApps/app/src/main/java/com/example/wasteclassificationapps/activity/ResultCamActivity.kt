package com.example.wasteclassificationapps.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wasteclassificationapps.R
import com.example.wasteclassificationapps.api.ApiConfiguration
import com.example.wasteclassificationapps.api.ResponseImageApi
import com.example.wasteclassificationapps.databinding.ActivityResultCamBinding
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResultCamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultCamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultCamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Result"

        val imagePath = intent.getStringExtra("RESULT_IMAGE")

        val imgbt =
            findViewById<View>(R.id.previewImageView) as ImageView

        val uri = Uri.parse(imagePath)
        imgbt.setImageURI(uri)

//        actionPostImage()
    }
//
//    private fun actionPostImage() {
//        binding.btnTouchAction.setOnClickListener {
//            postImageApi()
//        }
//    }
//
//    private fun postImageApi() {
//        val image: MultipartBody.Part = MultipartBody.Part.createFormData(
//            "RESULT_IMAGE")
//        val start = ApiConfiguration().getImageApi().imageFromApi(image)
//        start.enqueue(object : Callback<ResponseImageApi>{
//            override fun onResponse(
//                call: Call<ResponseImageApi>,
//                response: Response<ResponseImageApi>
//            ) {
//                val imageApi = response.body()
//                binding.resultType.text = imageApi!!.type
//                binding.resultDesc.text = imageApi.desc
//                binding.resultDo.text = imageApi.does
//                binding.resultDont.text = imageApi.dont
//                binding.resultExample.text = imageApi.example
//                binding.resultImpact.text = imageApi.impact
//            }
//            override fun onFailure(call: Call<ResponseImageApi>, t: Throwable) {
//                Log.e("Gagal memuat", t.message.toString())
//            }
//        })
//    }
}