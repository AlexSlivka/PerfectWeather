package com.example.perfectweather.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perfectweather.network.WeatherNowApi
import kotlinx.coroutines.launch

//DateUtils.formatElapsedTime

class MainViewModel : ViewModel() {

  /*  val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }*/

    // The current _word
    private val _word = MutableLiveData<String>()

    val word: LiveData<String>
        get() = _word

    // The list of words - the front of the list is the next _word to guess
    private lateinit var wordList: MutableList<String>

    init {
        _word.value = ""
        Log.i("MainViewModel", "MainViewModel created!")
        resetList()
        onCorrect()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "sun",
            "snow",
            "rain",
            "cloody"
        )
        wordList.shuffle()
    }

    fun onCorrect() {
        viewModelScope.launch {
            try {
                val listResult = WeatherNowApi.retrofitService.getProperties()
                _word.value = "Success: $listResult Weather properties retrieved"
            } catch (e: Exception) {
                _word.value = "Failure: ${e.message}"
            }
        }
    }

}