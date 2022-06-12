package com.example.wasteclassificationapps.activity

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wasteclassificationapps.api.ApiConfiguration
import com.example.wasteclassificationapps.api.ResponseImageApi
import com.example.wasteclassificationapps.databinding.ActivityPredictResultBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class PredictResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPredictResultBinding
    private var getImage: File? = null

    companion object {
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPredictResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail Prediksi Jenis Sampah"

        val myImage = intent.getSerializableExtra(EXTRA_IMAGE) as File
        getImage = myImage
        val result = BitmapFactory.decodeFile(myImage.path)
        Glide.with(this)
            .asBitmap()
            .load(result)
            .into(binding.detailImage)

        getPredict()

    }

    private fun getPredict() {
        if (getImage != null) {
            val image = getImage as File
            showLoading(true)
            val requestImageFile = image.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                "image",
                image.name,
                requestImageFile
            )

            val service = ApiConfiguration().getPredictApiService().postImage(imageMultipart)
            service.enqueue(object : Callback<ResponseImageApi> {
                override fun onResponse(
                    call: Call<ResponseImageApi>,
                    response: Response<ResponseImageApi>
                ) {
                    showLoading(false)
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            setDetailPredict(responseBody)
                            Toast.makeText(
                                this@PredictResultActivity,
                                responseBody.type,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseImageApi>, t: Throwable) {
                    showLoading(false)
                    Toast.makeText(
                        this@PredictResultActivity,
                        "Gagal",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        } else {
            Toast.makeText(
                this@PredictResultActivity,
                "Silakan upload gambar terlebih dahulu",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.scrollView.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.scrollView.visibility = View.VISIBLE
        }
    }

    private fun setDetailPredict(response: ResponseImageApi) {
        binding.detailPredictType.setText(response.type)
        binding.detailDescPredict.setText(response.desc)
        binding.detailExamplePredict.setText(response.example)
        binding.detailImpactPredict.setText(response.impact)
        binding.detailDoPredict.setText(response._do)
        binding.detailDontPredict.setText(response.dont)
    }
}