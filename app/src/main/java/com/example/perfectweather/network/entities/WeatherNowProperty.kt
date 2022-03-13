package com.example.perfectweather.network.entities

import com.example.perfectweather.domain.CurrentWeatherData
import com.squareup.moshi.Json

data class WeatherNowProperty
    (
    @Json(name = "coord") val coordinates: CoordRestModel,
    @Json(name = "weather") val weatherNow: List<WeatherRestModel>,
    @Json(name = "base") val base: String,
    @Json(name = "main") val main: MainRestModel,
    @Json(name = "visibility") val visibility: Int,
    @Json(name = "wind") val wind: WindRestModel,
    @Json(name = "clouds") val clouds: CloudsRestModel,
    @Json(name = "dt") val dateTime: Long,
    @Json(name = "sys") val sys: SysRestModel,
    @Json(name = "id") val id: Long,
    @Json(name = "timezone") val timezone: Int,
    @Json(name = "name") val nameCity: String,
    @Json(name = "cod") val cod: Int
)

data class NetworkCurrentWeatherContainer(val currentWeather: WeatherNowProperty)

fun NetworkCurrentWeatherContainer.asDomainModel(): CurrentWeatherData {
    return CurrentWeatherData(
        id = currentWeather.id,
        lon = currentWeather.coordinates.lon,
        lat = currentWeather.coordinates.lat,
        descriptionWeather = currentWeather.weatherNow[0].description,
        iconWeather = currentWeather.weatherNow[0].icon,
        temp = currentWeather.main.temp.toInt(),
        feelsLike = currentWeather.main.feelsLike.toInt(),
        pressure = currentWeather.main.pressure,
        humidity = currentWeather.main.humidity,
        speedWind = currentWeather.wind.speed.toInt(),
        degWind = currentWeather.wind.deg,
        dateTime = currentWeather.dateTime,
        country = currentWeather.sys.country,
        sunrise = currentWeather.sys.sunrise,
        sunset = currentWeather.sys.sunset,
        timezone = currentWeather.timezone,
        nameCity = currentWeather.nameCity
    )

}

fun WeatherNowProperty.asDomainModel(): CurrentWeatherData {
    return CurrentWeatherData(
        id = id,
        lon = coordinates.lon,
        lat = coordinates.lat,
        descriptionWeather =weatherNow[0].description,
        iconWeather = weatherNow[0].icon,
        temp = main.temp.toInt(),
        feelsLike = main.feelsLike.toInt(),
        pressure = main.pressure,
        humidity = main.humidity,
        speedWind = wind.speed.toInt(),
        degWind = wind.deg,
        dateTime = dateTime,
        country = sys.country,
        sunrise = sys.sunrise,
        sunset = sys.sunset,
        timezone = timezone,
        nameCity = nameCity
    )

}


/*

data class CurrentWeatherData (
    val id: Long,
    val lon: Float,
    val lat: Float,
    val descriptionWeather: String,
    val iconWeather: String,
    val temp: Float,
    val feelsLike: Float,
    val pressure: Int,
    val humidity: Int,
    val speedWind: Float,
    val degWind: Int,
    val dateTime: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
    val timezone: Int,
    val nameCity: String
)
    {
  "coord": {
    "lon": -122.08,
    "lat": 37.39
  },
  "weather": [
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01d"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 282.55,
    "feels_like": 281.86,
    "temp_min": 280.37,
    "temp_max": 284.26,
    "pressure": 1023,
    "humidity": 100
  },
  "visibility": 16093,
  "wind": {
    "speed": 1.5,
    "deg": 350
  },
  "clouds": {
    "all": 1
  },
  "dt": 1560350645,
  "sys": {
    "type": 1,
    "id": 5122,
    "message": 0.0139,
    "country": "US",
    "sunrise": 1560343627,
    "sunset": 1560396563
  },
  "timezone": -25200,
  "id": 420006353,
  "name": "Mountain View",
  "cod": 200
  }

    */