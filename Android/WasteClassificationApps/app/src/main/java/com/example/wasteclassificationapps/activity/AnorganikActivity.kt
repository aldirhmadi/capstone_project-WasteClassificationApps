package com.example.wasteclassificationapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wasteclassificationapps.R

class AnorganikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anorganik)
        supportActionBar?.hide()
    }
}