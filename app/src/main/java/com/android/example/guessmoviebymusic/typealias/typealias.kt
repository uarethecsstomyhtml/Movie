package com.android.example.guessmoviebymusic.`typealias`

import android.os.Build
import com.android.example.guessmoviebymusic.HintUi
import com.android.example.guessmoviebymusic.ShopUi
import com.android.example.guessmoviebymusic.base.domain.BaseUseCase
import com.android.example.guessmoviebymusic.base.domain.Either
import com.android.example.guessmoviebymusic.base.domain.Failure
import com.android.example.guessmoviebymusic.base.entity.NetworkResponse
import com.android.example.guessmoviebymusic.levels.data.db.LevelDb
import com.android.example.guessmoviebymusic.levels.domain.usecase.GetLevelsUseCase
import com.android.example.guessmoviebymusic.levels.entity.Level
import com.android.example.guessmoviebymusic.levels.presentation.LevelUi
import com.android.example.guessmoviebymusic.movie_details.AnswerUi
import com.android.example.guessmoviebymusic.movie_details.QuestionUi
import com.android.example.guessmoviebymusic.movies.data.db.MovieDb
import com.android.example.guessmoviebymusic.movies.domain.usecase.GetMoviesByLevelUseCase
import com.android.example.guessmoviebymusic.movies.entity.Movie
import com.android.example.guessmoviebymusic.movies.presentation.MovieUi
import com.android.example.guessmoviebymusic.movies.presentation.MoviesAdapter

/**
 * Network Response Lists
 */
typealias LevelList = List<Level>
typealias MovieList = List<Movie>

/**
 * Database Lists
 */
typealias LevelDbList = List<LevelDb>
typealias MovieDbList = List<MovieDb>

/**
 * NetworkResponses
 */
typealias LevelListNetworkResponse = NetworkResponse<LevelList>
typealias MovieListNetworkResponse = NetworkResponse<MovieList>

/**
 * Use Cases
 */
typealias BaseGetLevelsUseCase = BaseUseCase<LevelList, GetLevelsUseCase.Params>
typealias BaseGetMoviesByLevelUseCase = BaseUseCase<MovieList, GetMoviesByLevelUseCase.Params>

/**
 * Either
 */
typealias LevelListEither = Either<Failure, LevelList>
typealias MovieListEither = Either<Failure, MovieList>

/**
 * Adapter Ui Clicks
 */
typealias levelUiClick = (item: LevelUi) -> Unit
typealias movieUiClick = (item: MovieUi) -> Unit
typealias questionUiClick = (item: QuestionUi) -> Unit
typealias answerUiClick = (item: AnswerUi) -> Unit
typealias hintUiClick = (item: HintUi) -> Unit
typealias shopUiClick = (item: ShopUi) -> Unit

/**
 * Ui Lists
 */
typealias LevelUiList = List<LevelUi>
typealias MovieUiList = List<MovieUi>
typealias QuestionUiList = List<QuestionUi>
typealias AnswerUiList = List<AnswerUi>
typealias HintUiList = List<HintUi>
typealias ShopUiList = List<ShopUi>






