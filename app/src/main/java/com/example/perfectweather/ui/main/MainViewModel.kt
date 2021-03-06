package com.example.perfectweather.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.perfectweather.database.getDatabase
import com.example.perfectweather.domain.CurrentWeatherData
import com.example.perfectweather.network.WeatherNowApi
import com.example.perfectweather.network.entities.asDomainModel
import com.example.perfectweather.repository.CurrentWeatherRepository
import kotlinx.coroutines.launch
import java.io.IOException

//DateUtils.formatElapsedTime

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val currentWeatherRepository = CurrentWeatherRepository(getDatabase(application))

    // The current _currentWeather
    private var _currentWeather = MutableLiveData<CurrentWeatherData>()

    val currentWeather: LiveData<CurrentWeatherData> = currentWeatherRepository.currentWeather

    /**
     * Event triggered for network error. This is private to avoid exposing a
     * way to set this value to observers.
     */
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    /**
     * Event triggered for network error. Views should use this to get access
     * to the data.
     */
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    /**
     * Flag to display the error message. This is private to avoid exposing a
     * way to set this value to observers.
     */
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    /**
     * Flag to display the error message. Views should use this to get access
     * to the data.
     */
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown


    // The list of words - the front of the list is the next _word to guess
    private lateinit var wordList: MutableList<String>

    init {
        _currentWeather.value = CurrentWeatherData(
            id = 1L,
            lon = 1f,
            lat = 1f,
            descriptionWeather = "",
            iconWeather = "",
            temp = 0,
            feelsLike = 0,
            pressure = 0,
            humidity = 0,
            speedWind = 0,
            degWind = 0,
            dateTime = 0,
            country = "",
            sunrise = 0,
            sunset = 0,
            timezone = 0,
            nameCity = ""
        )

        Log.i("MainViewModel", "MainViewModel created!")

        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                currentWeatherRepository.refreshCurrentWeather()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false

            } catch (networkError: IOException) {
                // Show a Toast error message and hide the progress bar.
                if(currentWeather.value?.nameCity =="")
                    _eventNetworkError.value = true
            }
        }
    }

}