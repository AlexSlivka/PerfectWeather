package com.example.perfectweather.domain

data class CurrentWeatherData(
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
    var nameCity: String
)

/*data class WeatherNowProperty
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
*
data class CoordRestModel(
    @Json(name = "lon") val lon: Float,
    @Json(name = "lat") val lat: Float
)

 data class WeatherRestModel(
    @Json(name = "id") val id: Int,
    @Json(name = "main") val main: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String
)

data class MainRestModel(
    @Json(name = "temp") val temp: Float,
    @Json(name = "feels_like") val feelsLike: Float,
    @Json(name = "temp_min") val tempMin: Float,
    @Json(name = "temp_max") val tempMax: Float,
    @Json(name = "pressure") val pressure: Int,
    @Json(name = "humidity") val humidity: Int
)

data class WindRestModel(
    @Json(name = "speed") val speed: Float,
    @Json(name = "deg") val deg: Int
)

data class CloudsRestModel(
    @Json(name = "all") val all: Int  //Облачность
)

data class SysRestModel(
    @Json(name = "type") val type: Int,
    @Json(name = "id") val id: Int,
   // @Json(name = "message") val message: Double,
    @Json(name = "country") val country: String,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long
)

* */