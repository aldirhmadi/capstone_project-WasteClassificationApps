package com.example.wasteclassificationapps.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.wasteclassificationapps.SettingPreferences
import com.example.wasteclassificationapps.databinding.ActivitySplashBinding
import com.example.wasteclassificationapps.viewModel.SettingViewModel
import com.example.wasteclassificationapps.viewModel.SettingViewModelFactory

class SplashActivity : AppCompatActivity() {

    val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = "settings")

    private lateinit var binding: ActivitySplashBinding

    private var SPLASH_SCREEN_TIME: Long = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        applyChangeTheme()

        Handler(Looper.myLooper()!!).postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, SPLASH_SCREEN_TIME)
    }

    private fun applyChangeTheme(){
        val pref =SettingPreferences.getInstance(dataStore)
        val settingViewModel =ViewModelProvider(this, SettingViewModelFactory(pref))[SettingViewModel::class.java]

        settingViewModel.getChangeThemeSetting().observe(this) {
            if (it) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}