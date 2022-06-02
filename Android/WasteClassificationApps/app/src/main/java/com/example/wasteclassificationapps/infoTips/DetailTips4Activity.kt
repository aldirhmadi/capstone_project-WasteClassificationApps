package com.example.wasteclassificationapps.infoTips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteclassificationapps.databinding.ActivityDetailTips4Binding

class DetailTips4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTips4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTips4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Info & Tips Cara Memilah Sampah"

    }
}