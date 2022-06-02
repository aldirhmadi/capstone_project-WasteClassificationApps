package com.example.wasteclassificationapps.infoTips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteclassificationapps.databinding.ActivityDeatilTips1Binding

class DeatilTips1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDeatilTips1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeatilTips1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Info & Tips Cara Memilah Sampah"
    }
}