package com.example.wasteclassificationapps.infoTips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteclassificationapps.databinding.ActivityDetailTips5Binding

class DetailTips5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTips5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTips5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Info & Tips Cara Memilah Sampah"

    }
}