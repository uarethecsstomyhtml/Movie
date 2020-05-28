package com.example.android.movies.presentation.ui.levels

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.movies.R
import com.example.android.movies.presentation.ui.levels.LevelsFragmentDirections.Companion.actionLevelsToMovies
import com.example.android.sound_components.SOUND_LEVEL_NAME
import com.example.android.ui_components.ResultState
import com.example.android.ui_components.ResultState.*
import com.example.android.ui_components.gone
import com.example.android.ui_components.visible
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_levels.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import timber.log.Timber
import kotlin.Error

class LevelsFragment : Fragment(R.layout.fragment_levels) {

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>
    private val viewModel: LevelsViewModel by viewModel()

    private lateinit var pbLoading: View
    private lateinit var layoutErrorNetworkResponse: ConstraintLayout

    private val soundLevel: Int by inject(named(SOUND_LEVEL_NAME))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")
        setupAdapter()
        loadData()
        viewModel.levels.observe(viewLifecycleOwner, Observer(::onLevelsStateChange))
        pbLoading = view.findViewById(R.id.pbLoading)
        layoutErrorNetworkResponse = view.findViewById(R.id.layoutErrorNetworkResponse)
//        swipeLevels.setOnRefreshListener(this)
    }

    private fun setupAdapter() {
        Timber.d("setupAdapter")
        adapter = GroupAdapter()
        rvLevels.adapter = adapter
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.loadData()
    }

    private fun onLevelsStateChange(state: ResultState<LevelUiList>) {
        Timber.d("onLevelsStateChange")
        when (state) {
            is Loading -> onLoading()
            is Error -> onFailure()
            is Success -> onSuccess(state.data)
        }
    }

    private fun onLoading() {
        Timber.d("showLoading")
//        layoutErrorNetworkResponse.gone()
        pbLoading.visible()
    }

    private fun onFailure() {
        Timber.i("showErrorState")
        hideLoading()
        layoutErrorNetworkResponse.visible()
    }

    private fun onSuccess(levels: LevelUiList) {
        Timber.i("showSuccess, levels = $levels")
        hideLoading()
        for (level in levels) adapter.add(LevelItem(level, soundLevel, ::onLevelClick))
    }

    private fun hideLoading() {
        Timber.i("hideLoading")
        pbLoading.gone()
    }

    private fun onLevelClick(level: LevelUi) {
        Timber.i("onLevelClick, level = $level")

        val action = actionLevelsToMovies(levelUi = level)
        findNavController().navigate(action)
    }

}
