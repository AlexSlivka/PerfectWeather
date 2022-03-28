package com.example.perfectweather.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CurrentWeatherDao {

    @Query("select * from current_weather_table ORDER BY dateTime DESC LIMIT 1 ")
    fun getCurrentWeather(): LiveData<DatabaseCurrentWeather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( currentWeather: DatabaseCurrentWeather)
}

@Database(entities = [DatabaseCurrentWeather::class], version = 1)
abstract class CurrentWeatherDatabase: RoomDatabase() {
    abstract val currentWeatherDao: CurrentWeatherDao
}

private lateinit var INSTANCE: CurrentWeatherDatabase

fun getDatabase(context: Context): CurrentWeatherDatabase {
    synchronized(CurrentWeatherDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                CurrentWeatherDatabase::class.java,
                "currentWeather").build()
        }
    }
    return INSTANCE
}