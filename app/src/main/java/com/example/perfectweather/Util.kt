package com.example.perfectweather

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat

private const val TAG: String = "UtilDate"

class Util {

    companion object {

        fun convertIconToRDrawable(icon: String): Int = when (icon) {
            "01d" -> R.drawable.icon_01d
            "01n" -> R.drawable.icon_01n
            "02d" -> R.drawable.icon_02d
            "02n" -> R.drawable.icon_02n
            "03d" -> R.drawable.icon_03d
            "03n" -> R.drawable.icon_03n
            "04d" -> R.drawable.icon_04d
            "04n" -> R.drawable.icon_04n
            "09d" -> R.drawable.icon_09d
            "09n" -> R.drawable.icon_09n
            "10d" -> R.drawable.icon_10d
            "10n" -> R.drawable.icon_10n
            "11d" -> R.drawable.icon_11d
            "11n" -> R.drawable.icon_11n
            "13d" -> R.drawable.icon_13d
            "13n" -> R.drawable.icon_13n
            "50d" -> R.drawable.icon_50d
            "50n" -> R.drawable.icon_50n
            else -> {
                R.drawable.icon_01d
            }
        }

        @SuppressLint("SimpleDateFormat")
        fun convertLongToDateString(systemTime: Long): String {
            val sdf = SimpleDateFormat("HH:mm dd-MM-yyyy")
            val date = java.util.Date(systemTime * 1000)
            return sdf.format(date).toString()
        }

        fun convertPressureGPascalToMmRtStb(pressure: Int): String {
            return ((pressure * 75) / 100).toString()
        }

    }
}