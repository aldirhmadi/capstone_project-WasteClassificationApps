package com.example.wasteclassificationapps.activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wasteclassificationapps.databinding.ActivityResultCamBinding
import com.example.wasteclassificationapps.uriToFile
import java.io.File

class ResultCamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultCamBinding
    private var getImage: File? = null

    companion object {
        const val EXTRA_FILE = "extra_file"
        const val EXTRA_GALLERY = "extra_gallery"
        const val REQUEST_GALLERY = "request_gallery"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultCamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Result"

        val myImage = intent.getSerializableExtra(EXTRA_FILE) as File
        getImage = myImage
        val result = BitmapFactory.decodeFile(myImage.path)
        Glide.with(this)
            .asBitmap()
            .load(result)
            .apply(RequestOptions().override(600, 1200))
            .into(binding.previewImageView)

        binding.predictButton.setOnClickListener {
            val detailIntent = Intent(this@ResultCamActivity, PredictResultActivity::class.java)
            detailIntent.putExtra(PredictResultActivity.EXTRA_IMAGE, myImage)
            startActivity(detailIntent)
            finish()
        }

        binding.retakeButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = uriToFile(selectedImg, this@ResultCamActivity)
            val galleryIntent = Intent(this, ResultCamActivity::class.java)
            galleryIntent.putExtra(ResultCamActivity.EXTRA_GALLERY, selectedImg)
            galleryIntent.putExtra(ResultCamActivity.REQUEST_GALLERY, 1)
            startActivity(galleryIntent)
        }
    }
}




















