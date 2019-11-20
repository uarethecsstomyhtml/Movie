package com.android.example.guessmoviebymusic.levels.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.base.presentation.ResultState
import com.android.example.guessmoviebymusic.`typealias`.LevelUiList
import com.android.example.guessmoviebymusic.extension.gone
import com.android.example.guessmoviebymusic.extension.visible
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.content_network_error.*
import kotlinx.android.synthetic.main.fragment_levels.*
import org.koin.android.ext.android.inject
import timber.log.Timber
import com.android.example.guessmoviebymusic.levels.presentation.LevelsFragmentDirections.Companion.actionLevelsFragmentToMoviesFragment as openMoviesFragment

class LevelsFragment : Fragment(R.layout.fragment_levels) {

    private lateinit var adapter: LevelsAdapter
    private val viewModel: LevelsViewModel by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated")
        loadData()
        initAdapter()
        initRv()
        observeLevelsStateChange()
        openAdsGdprDialog()
    }

    private fun openAdsGdprDialog() {
        Timber.d("openAdsGdprDialog")
        findNavController().navigate(R.id.adsGdprDialog)
    }

    private fun observeLevelsStateChange() {
        Timber.d("observeLevelsStateChange")
        viewModel.state.observe(viewLifecycleOwner, Observer(::onLevelsStateChange))
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.loadData()
    }

    private fun initAdapter() {
        Timber.d("initAdapter")
        adapter = LevelsAdapter(::onLevelClick)
    }

    private fun initRv() {
        Timber.d("initRv")
        rvLevels.adapter = adapter
    }

    private fun onLevelsStateChange(state: ResultState<LevelUiList>) {
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

    private fun showSuccess(data: LevelUiList) {
        Timber.d("showSuccess $data")
        hideLoading()
        adapter.submitList(data)
    }

    private fun hideLoading() {
        Timber.d("hideLoading")
        pbLoading.gone()
    }

    private fun onLevelClick(item: LevelUi) {
        Timber.d("onLevelClick $item")
        val action = openMoviesFragment(levelId = item.id, levelBgColor = item.bgColor, levelName = item.name)
        findNavController().navigate(action)
    }
}
