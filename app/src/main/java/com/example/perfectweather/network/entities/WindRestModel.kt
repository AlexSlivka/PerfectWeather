package com.example.perfectweather.network.entities

import com.squareup.moshi.Json

data class WindRestModel(
    @Json(name = "speed") val speed: Float,
    @Json(name = "deg") val deg: Int
)

/*
"wind": {
    "speed": 1.5,
    "deg": 350
  },
  */