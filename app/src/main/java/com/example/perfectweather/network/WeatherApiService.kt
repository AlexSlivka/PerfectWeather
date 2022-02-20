package com.example.perfectweather.network

import com.example.perfectweather.network.entities.WeatherNowProperty
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
private const val API_KEY = "f52310dbfdea19138786c8eae8eb6138"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeatherNowApiService {
    @GET("weather?lat=55.7504461&lon=37.6174943&appid=f52310dbfdea19138786c8eae8eb6138&units=metric&lang=ru")
    suspend fun getProperties():WeatherNowProperty
}

object WeatherNowApi {
    val retrofitService: WeatherNowApiService by lazy { retrofit.create(WeatherNowApiService::class.java) }
}