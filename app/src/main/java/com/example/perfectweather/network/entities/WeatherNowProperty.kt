package com.example.perfectweather.network.entities

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

/*
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