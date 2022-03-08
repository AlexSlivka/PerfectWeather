package com.example.perfectweather

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class Util {
    /**
     * Take the Long milliseconds returned by the system and stored in Room,
     * and convert it to a nicely formatted string for display.
     *
     * EEEE - Display the long letter version of the weekday
     * MMM - Display the letter abbreviation of the nmotny
     * dd-yyyy - day in month and full year numerically
     * HH:mm - Hours and minutes in 24hr format
     */
    @SuppressLint("SimpleDateFormat")
    fun convertLongToDateString(systemTime: Long): String {
        return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
            .format(systemTime).toString()
    }



   companion object{
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
   }
}