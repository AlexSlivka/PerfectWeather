package com.example.perfectweather.network.entities

import com.squareup.moshi.Json

data class SysRestModel(
    @Json(name = "type") val type: Int,
    @Json(name = "id") val id: Int,
   // @Json(name = "message") val message: Double,
    @Json(name = "country") val country: String,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long
)

/*
"sys": {
    "type": 1,
    "id": 5122,
    "message": 0.0139,
    "country": "US",
    "sunrise": 1560343627,
    "sunset": 1560396563
  },
 */