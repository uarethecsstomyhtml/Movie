package com.example.android.hints.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias HintUiList = List<HintUi>

typealias HintUiListMutable = MutableLiveData<HintUiList>
typealias HintUiListLive = LiveData<HintUiList>

typealias HintUiClick = (HintUi) -> Unit