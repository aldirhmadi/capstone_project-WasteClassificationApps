package com.example.wasteclassificationapps.infoTips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteclassificationapps.databinding.ActivityDetailTips3Binding

class DetailTips3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTips3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTips3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Info & Tips Cara Memilah Sampah"

    }
}