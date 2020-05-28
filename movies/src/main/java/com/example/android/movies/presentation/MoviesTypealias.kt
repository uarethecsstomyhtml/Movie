package com.example.android.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.movies.data.local.MovieDb
import com.example.android.movies.domain.usecase.GetMoviesByLevelUseCase
import com.example.android.movies.entity.MovieDto
import com.example.android.movies.presentation.ui.MovieUi
import com.example.android.movies.presentation.ui.movie_details.answers.AnswerUi
import com.example.android.movies.presentation.ui.movie_details.questions.QuestionUi
import com.example.android.network.domain.BaseUseCase
import com.example.android.network.domain.Either
import com.example.android.network.domain.Failure
import com.example.android.network.entity.NetworkResponse
import com.example.android.ui_components.ResultState


// Network Response Lists
typealias MovieDtoList = List<MovieDto>

// Database Lists
typealias MovieDbList = List<MovieDb>

// NetworkResponses
typealias MovieDtoListResponse = NetworkResponse<MovieDtoList>

// Use Cases
typealias BaseGetMoviesByLevelUseCase = BaseUseCase<MovieDtoList, GetMoviesByLevelUseCase.Params>

// Either
typealias MovieDtoListEither = Either<Failure, MovieDtoList>

// MutableLiveData & LiveData
typealias MovieUiListResultMutable = MutableLiveData<ResultState<MovieUiList>>
typealias MovieUiListResultLive = LiveData<ResultState<MovieUiList>>


// Adapter Ui Clicks
typealias MovieUiClick = (MovieUi) -> Unit

// Ui Lists
typealias MovieUiList = List<MovieUi>
typealias QuestionUiList = List<QuestionUi>
typealias AnswerUiList = List<AnswerUi>

