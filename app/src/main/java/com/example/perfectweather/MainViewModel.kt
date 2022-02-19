package com.example.perfectweather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
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
        if (wordList.isEmpty()) {
            Log.i("MainViewModel", "(wordList Empty!")

        } else {
            //Select and remove a _word from the list
            _word.value = wordList.removeAt(0)
        }
    }
}