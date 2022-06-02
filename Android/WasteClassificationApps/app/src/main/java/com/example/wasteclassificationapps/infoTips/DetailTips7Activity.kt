package com.example.wasteclassificationapps.infoTips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteclassificationapps.databinding.ActivityDetailTips7Binding

class DetailTips7Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTips7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTips7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Info & Tips Cara Memilah Sampah"

    }
}