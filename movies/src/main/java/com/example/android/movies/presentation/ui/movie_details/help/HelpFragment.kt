package com.example.android.movies.presentation.ui.movie_details.help

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.movies.R
import com.example.android.movies.presentation.MovieStatus
import com.example.android.movies.presentation.MovieUiList
import com.example.android.movies.presentation.ui.MoviesFragmentDirections.Companion.actionMoviesFragmentToMovieDetailsFragment
import com.example.android.movies.presentation.ui.levels.LevelUi
import com.example.android.movies.presentation.ui.movie_details.MovieDetailsViewModel
import com.example.android.sound_components.SOUND_BACK_TO_LEVEL_NAME
import com.example.android.sound_components.SOUND_MOVIE_NAME
import com.example.android.ui_components.BaseFragment
import com.example.android.ui_components.ResultState
import com.example.android.ui_components.ResultState.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_help.*
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber

class HelpFragment : Fragment(R.layout.fragment_help) {

    private val soundMovieClick: Int by inject(named(SOUND_MOVIE_NAME))
    private val soundBackToLevel: Int by inject(named(SOUND_BACK_TO_LEVEL_NAME))

    private val viewModel: MovieDetailsViewModel by inject()

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")
        setupAdapter()
        loadHelp()
        viewModel.help.observe(viewLifecycleOwner, Observer(::onHelpStateChange))
    }

    private fun setupAdapter() {
        Timber.i("setupAdapter")
        adapter = GroupAdapter()
        rvHelp.adapter = adapter
    }

    private fun loadHelp() {
        Timber.d("loadHelp")
        viewModel.loadHelp()
    }

    private fun onHelpStateChange(helpTypes: List<HelpType>) {
        Timber.d("onHelpStateChange")
        for (helpType in helpTypes) adapter.add(HelpItem(helpType))
    }


    private fun onItemHelpClick(item: HelpType) {
    }

    private fun openMovieDetailsFragment() {
    }

}
