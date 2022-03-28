package com.example.perfectweather.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.perfectweather.database.CurrentWeatherDatabase
import com.example.perfectweather.database.asDomainModel
import com.example.perfectweather.domain.CurrentWeatherData
import com.example.perfectweather.network.WeatherNowApi
import com.example.perfectweather.network.entities.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG: String = "CurrentWeatherRepository"

class CurrentWeatherRepository(private val database: CurrentWeatherDatabase) {
    val currentWeather: LiveData<CurrentWeatherData> =
        Transformations.map(database.currentWeatherDao.getCurrentWeather()) {
            it.asDomainModel()
        }

    suspend fun refreshCurrentWeather() {
        withContext(Dispatchers.IO) {
            val listResult = WeatherNowApi.retrofitService.getProperties()
            Log.d(TAG, "Success: $listResult Weather properties from Network")
            database.currentWeatherDao.insert(listResult.asDatabaseModel())
            Log.d(TAG, "Success: ${listResult.asDatabaseModel()} Weather properties to asDatabaseMode")
        }
    }

}