package com.example.android.movies.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.movies.R
import com.example.android.movies.presentation.MovieStatus
import com.example.android.movies.presentation.MovieUiList
import com.example.android.movies.presentation.ui.MoviesFragmentDirections.Companion.actionMoviesFragmentToMovieDetailsFragment
import com.example.android.movies.presentation.ui.levels.LevelUi
import com.example.android.sound_components.SOUND_BACK_TO_LEVEL_NAME
import com.example.android.sound_components.SOUND_MOVIE_NAME
import com.example.android.ui_components.BaseFragment
import com.example.android.ui_components.ResultState
import com.example.android.ui_components.ResultState.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber

class MoviesFragment : BaseFragment(R.layout.fragment_movies) {

    private val args: MoviesFragmentArgs by navArgs()
    private val viewModel: MoviesViewModel by inject()

    private val soundMovieClick: Int by inject(named(SOUND_MOVIE_NAME))
    private val soundBackToLevel: Int by inject(named(SOUND_BACK_TO_LEVEL_NAME))

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun soundOnBackPressed() = soundBackToLevel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")
        loadMoviesByLevelId()
        setupAdapter()
        fillViews()
        toolbar.setNavigationOnClickListener(::popBackStack)
        viewModel.movies.observe(viewLifecycleOwner, Observer(::onMoviesStateChange))
    }

    private fun setupAdapter() {
        Timber.i("setupAdapter")
        adapter = GroupAdapter()
        rvMovies.adapter = adapter
    }

    private fun fillViews() {
        Timber.d("fillViews")
        fillCollapsingToolbarLayout()
        fillToolbar()
        fillLevelImage()
    }

    private fun getLevel(): LevelUi {
        Timber.i("getLevel = ${args.levelUi}")
        return args.levelUi
    }

    private fun fillCollapsingToolbarLayout() {
        Timber.d("fillCollapsingToolbarLayout")
        with(collapsingToolbarLayout) {
            setBackgroundColor(getLevel().colorHex)
            setContentScrimColor(getLevel().colorHex)
        }
    }

    private fun fillToolbar() {
        Timber.i("fillToolbar, getLevel().name = ${getLevel().name}")
        toolbar.title = getLevel().name
    }

    private fun fillLevelImage() {
        Timber.d("fillToolbar, getLevel().imgRes = ${getLevel().imgRes}")
        //  imgLevel.loadRes(getLevel().imgRes)
        imgLevel.setImageResource(getLevel().imgRes)
    }


    private fun loadMoviesByLevelId() {
        Timber.d("loadMoviesByLevelId")
        viewModel.loadMoviesByLevelId(levelId = getLevel().id)
    }

    private fun onMoviesStateChange(state: ResultState<MovieUiList>) {
        Timber.d("onLevelsStateChange")
        when (state) {
            is Loading -> showLoading()
            is Error -> showErrorState()
            is Success -> showSuccess(state.data)
        }
    }

    private fun showLoading() {
        Timber.d("showLoading")
//        layoutErrorNetworkResponse.gone()
//        pbLoading.visible()
    }

    private fun showErrorState() {
        Timber.d("showErrorState")
        hideLoading()
//        layoutErrorNetworkResponse.visible()
    }

    private fun showSuccess(movies: MovieUiList) {
        Timber.d("showSuccess, movies = $movies")
        hideLoading()
        for (movie in movies) adapter.add(
            MovieItem(
                movie,
                getLevel().bgColor,
                soundMovieClick,
                ::onMovieClick
            )
        )
    }

    private fun onMovieClick(item: MovieUi) {
        Timber.d("onMovieClick $item")
        when (item.status) {
            MovieStatus.OPEN -> openMovieDetailsFragment()
            else -> Toast.makeText(context, "Отгадайте еще фильмы", Toast.LENGTH_LONG).show()
        }
    }

    private fun openMovieDetailsFragment() {
        val action = actionMoviesFragmentToMovieDetailsFragment(bgColor = getLevel().bgColor)
        findNavController().navigate(action)
    }

    private fun hideLoading() {
        Timber.d("hideLoading")
//        pbLoading.gone()
    }
}
