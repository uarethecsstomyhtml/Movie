package com.android.example.guessmoviebymusic

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.URLSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.android.example.guessmoviebymusic.base.presentation.MainActivity.Companion.APPODEAL_PRIVACY_POLICY_URL
import com.android.example.guessmoviebymusic.victory.AdsGdprResultViewModel
//import com.appodeal.ads.Appodeal
import org.koin.android.ext.android.inject
import timber.log.Timber

class AdsGdprResultDialog : DialogFragment() {

    private val viewModel: AdsGdprResultViewModel by inject()

    override fun onStart() {
        Timber.d("onStart")
        super.onStart()
        dialog?.window?.apply {
            setLayout(MATCH_PARENT, MATCH_PARENT)
            setWindowAnimations(R.style.AppTheme_Slide)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("onActivityCreated")
        return inflater.inflate(R.layout.dialog_ads_gdpr_result, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate")
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        isCancelable = false
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