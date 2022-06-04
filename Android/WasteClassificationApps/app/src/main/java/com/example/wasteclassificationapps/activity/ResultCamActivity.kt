package com.example.wasteclassificationapps.activity

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.wasteclassificationapps.R


class ResultCamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_cam)

        val imagePath = intent.getStringExtra("RESULT_IMAGE")

        val imgbt =
            findViewById<View>(R.id.previewImageView) as ImageView

        val uri = Uri.parse(imagePath)
        imgbt.setImageURI(uri)

        supportActionBar?.title = "Result"
    }
}