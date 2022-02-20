package com.example.perfectweather.network.entities

import com.squareup.moshi.Json

data class CloudsRestModel(
    @Json(name = "all") val all: Int  //Облачность
)

/*
"clouds": {
    "all": 1
}
*/