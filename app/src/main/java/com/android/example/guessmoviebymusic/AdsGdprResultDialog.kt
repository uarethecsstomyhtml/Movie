package com.android.example.guessmoviebymusic

import android.os.Bundle
import androidx.lifecycle.Observer
import com.android.example.guessmoviebymusic.base.presentation.BaseFullDialogFragment
import com.android.example.guessmoviebymusic.victory.AdsGdprResultViewModel
//import com.appodeal.ads.Appodeal
import org.koin.android.ext.android.inject
import timber.log.Timber

class AdsGdprResultDialog : BaseFullDialogFragment() {

    private val viewModel: AdsGdprResultViewModel by inject()

    override fun getLayout() = R.layout.dialog_ads_gdpr_result

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
//        isCancelable = false
        observeCloseState()
    }

    private fun navigationCloseClick() {
        viewModel.callClose()
    }

    private fun observeCloseState() {
        viewModel.close.observe(this, Observer(::closeDialog))
    }

    @Suppress("UNUSED_PARAMETER")
    private fun closeDialog(unit: Unit) {
        dismiss()
    }


}