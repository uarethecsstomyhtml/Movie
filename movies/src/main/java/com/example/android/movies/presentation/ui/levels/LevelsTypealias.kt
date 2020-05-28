package com.example.android.movies.presentation.ui.levels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.movies.data.local.levels.LevelDb
import com.example.android.movies.domain.usecase.GetLevelsUseCase
import com.example.android.movies.entity.LevelDto
import com.example.android.network.domain.BaseUseCase
import com.example.android.network.domain.Either
import com.example.android.network.domain.Failure
import com.example.android.network.entity.NetworkResponse
import com.example.android.ui_components.ResultState

// Dto Lists
typealias LevelDtoList = List<LevelDto>

// Db Lists
typealias LevelDbList = List<LevelDb>

// NetworkResponses
typealias LevelDtoListResponse = NetworkResponse<LevelDtoList>

// UseCases
typealias BaseGetLevelsUseCase = BaseUseCase<LevelDtoList, GetLevelsUseCase.Params>

// Either
typealias LevelDtoListEither = Either<Failure, LevelDtoList>

// MutableLiveData & LiveData
typealias LevelUiListResultMutable = MutableLiveData<ResultState<LevelUiList>>
typealias LevelUiListResultLive = LiveData<ResultState<LevelUiList>>

// Ui Lists
typealias LevelUiList = List<LevelUi>

// Adapter Ui Clicks
typealias LevelUiClick = (LevelUi) -> Unit









