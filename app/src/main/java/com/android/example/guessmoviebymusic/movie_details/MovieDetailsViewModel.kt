package com.android.example.guessmoviebymusic.movie_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieDetailsViewModel() : ViewModel() {

    val isPlayMusic = MutableLiveData<Boolean>().apply {
        value = false
    }

    fun test() {}

    fun onClickPlayOrStopMusic() {
        isPlayMusic.value = !isPlayMusic.value!!
    }


}