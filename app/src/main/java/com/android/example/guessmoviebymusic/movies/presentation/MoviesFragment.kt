package com.android.example.guessmoviebymusic.movies.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.MovieUiList
import com.android.example.guessmoviebymusic.base.presentation.ResultState
import com.android.example.guessmoviebymusic.extension.gone
import com.android.example.guessmoviebymusic.extension.visible
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.content_network_error.*
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private val args: MoviesFragmentArgs by navArgs()
    private val viewModel: MoviesViewModel by inject()

    private lateinit var adapter: MoviesAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated")
        loadData()
        initAdapter()
        initRv()
        observeMoviesStateChange()
        getLevelName()
        appbarLayout.setBackgroundColor(Color.parseColor(getLevelBgColor()))
        toolbar.title = getLevelName()
        toolbar.setBackgroundColor(Color.parseColor(getLevelBgColor()))
        collapsingToolbarLayout.setContentScrimColor(Color.parseColor(getLevelBgColor()))
        toolbar.setTitleTextColor(ContextCompat.getColor(context!!, R.color.white))
    }

    private fun getLevelBgColor(): String {
        Timber.d("getLevelBgColor: ${args.levelBgColor}")
        return args.levelBgColor
    }
    private fun getLevelId(): Long {
        Timber.d("getLevelId: ${args.levelId}")
        return args.levelId
    }
    private fun getLevelName(): String {
        Timber.d("getLevelName: ${args.levelName}")
        return args.levelName
    }

    private fun observeMoviesStateChange() {
        Timber.d("observeMoviesStateChange")
        viewModel.state.observe(viewLifecycleOwner, Observer(::onMoviesStateChange))
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.loadData(levelId = getLevelId())
    }

    private fun initAdapter() {
        Timber.d("initAdapter")
        adapter = MoviesAdapter(getLevelBgColor(), ::onMovieClick)
    }

    private fun initRv() {
        Timber.d("initRv")
        rvMovies.adapter = adapter
    }

    private fun onMovieClick(item: MovieUi) {
        Timber.d("onMovieClick $item")
       // val action = openMovieDetailsFragment(bgColor = item.bgColor)
       // findNavController().navigate(action)
    }

    private fun onMoviesStateChange(state: ResultState<MovieUiList>) {
        Timber.d("onLevelsStateChange")
        when (state) {
            is ResultState.Loading -> showLoading()
            is ResultState.Error -> showErrorState()
            is ResultState.Success -> showSuccess(state.data)
        }
    }

    private fun showLoading() {
        Timber.d("showLoading")
        layoutErrorNetworkResponse.gone()
        pbLoading.visible()
    }

    private fun showErrorState() {
        Timber.d("showErrorState")
        hideLoading()
        layoutErrorNetworkResponse.visible()
    }

    private fun showSuccess(data: MovieUiList) {
        Timber.d("showSuccess $data")
        hideLoading()
        adapter.submitList(data)
    }

    private fun hideLoading() {
        Timber.d("hideLoading")
        pbLoading.gone()
    }
}
