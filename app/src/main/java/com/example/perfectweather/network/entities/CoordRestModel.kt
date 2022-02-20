package com.example.perfectweather.network.entities

import com.squareup.moshi.Json

data class CoordRestModel(
    @Json(name = "lon") val lon: Float,
    @Json(name = "lat") val lat: Float
)