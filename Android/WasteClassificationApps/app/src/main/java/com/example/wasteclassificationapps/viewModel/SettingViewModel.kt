package com.example.wasteclassificationapps.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.wasteclassificationapps.SettingPreferences
import kotlinx.coroutines.launch

class SettingViewModel(private val pref: SettingPreferences) : ViewModel() {

    fun getChangeThemeSetting(): LiveData<Boolean> {
        return pref.getChangeThemeSetting().asLiveData()
    }

    fun saveChangeThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            pref.saveChangeThemeSetting(isDarkModeActive)
        }
    }

}