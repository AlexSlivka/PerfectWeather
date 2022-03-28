package com.example.perfectweather.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.perfectweather.domain.CurrentWeatherData

@Entity(tableName = "current_weather_table")
data class DatabaseCurrentWeather constructor(
    @PrimaryKey
    val id: Long,
    val lon: Float,
    val lat: Float,
    val descriptionWeather: String,
    val iconWeather: String,
    val temp: Int,
    val feelsLike: Int,
    val pressure: Int,
    val humidity: Int,
    val speedWind: Int,
    val degWind: Int,
    val dateTime: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
    val timezone: Int,
    val nameCity: String
)

fun List<DatabaseCurrentWeather>.asDomainModel(): List<CurrentWeatherData> {
    return map {
        CurrentWeatherData(
            id = it.id,
            lon = it.lon,
            lat = it.lat,
            descriptionWeather = it.descriptionWeather,
            iconWeather = it.iconWeather,
            temp = it.temp,
            feelsLike = it.feelsLike,
            pressure = it.pressure,
            humidity = it.humidity,
            speedWind = it.speedWind,
            degWind = it.degWind,
            dateTime = it.dateTime,
            country = it.country,
            sunrise = it.sunrise,
            sunset = it.sunset,
            timezone = it.timezone,
            nameCity = it.nameCity
        )
    }
}

fun DatabaseCurrentWeather.asDomainModel(): CurrentWeatherData {
    return CurrentWeatherData(
        id = id,
        lon = lon,
        lat = lat,
        descriptionWeather = descriptionWeather,
        iconWeather = iconWeather,
        temp = temp,
        feelsLike = feelsLike,
        pressure = pressure,
        humidity = humidity,
        speedWind = speedWind,
        degWind = degWind,
        dateTime = dateTime,
        country = country,
        sunrise = sunrise,
        sunset = sunset,
        timezone = timezone,
        nameCity = nameCity
    )

}