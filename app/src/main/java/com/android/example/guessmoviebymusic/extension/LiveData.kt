package com.android.example.guessmoviebymusic.extension

import androidx.lifecycle.MutableLiveData
import com.android.example.guessmoviebymusic.base.presentation.ResultState


fun <T> MutableLiveData<ResultState<T>>.setSuccess(data: T) =
    postValue(ResultState.Success(data))

fun <T> MutableLiveData<ResultState<T>>.setLoading() =
    postValue(ResultState.Loading(null))

fun <T> MutableLiveData<ResultState<T>>.setError(e: Throwable, message: T? = null) =
    postValue(ResultState.Error(e, message))

fun <T> MutableLiveData<T>.call() = postValue(null)