package com.android.example.guessmoviebymusic

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android.example.guessmoviebymusic.R.string.dialog_ads_gdpr_agree_text
import com.android.example.guessmoviebymusic.R.string.dialog_ads_gdpr_disagree_text
import com.android.example.guessmoviebymusic.base.presentation.BaseFullDialogFragment
import com.android.example.guessmoviebymusic.base.presentation.MainActivity
import com.android.example.guessmoviebymusic.extension.getApplicationName
import com.android.example.guessmoviebymusic.AdsGdprDialogDirections.Companion.actionAdsGdprDialogToAdsGdprResultDialog as openAdsResultDialog
import com.android.example.guessmoviebymusic.extension.setSafeOnClickListener
import kotlinx.android.synthetic.main.dialog_ads_gdpr.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class AdsGdprDialog : BaseFullDialogFragment() {

    private val viewModel: AdsGdprViewModel by inject()

    override fun getLayout() = R.layout.dialog_ads_gdpr

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        //isCancelable = false
        prepareGDPR()
        observeDescriptionResState()
        btnYes.setSafeOnClickListener(::onClickYes)
        btnNo.setSafeOnClickListener(::onClickNo)
    }

    private fun prepareGDPR() {
        Timber.d("prepareGDPR")
        val learnMore = getString(R.string.learn_more)
        val mainText = getString(R.string.dialog_ads_gdpr_main_text, context?.getApplicationName())
        val startPosition = mainText.indexOf(learnMore)
        val endPosition = startPosition + learnMore.length
        val spannableMain = SpannableString(mainText)
        spannableMain.setSpan(URLSpan(MainActivity.APPODEAL_PRIVACY_POLICY_URL), startPosition, endPosition, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        with(tvAdsDescription) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableMain
        }

    }

    private fun observeDescriptionResState() {
        Timber.i("observeDescriptionResState")
        viewModel.descriptionRes.observe(this, Observer(::openAdsGdpResult))
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickYes(view: View) {
        Timber.i("onClickYes")
        viewModel.setDescriptionRes(dialog_ads_gdpr_agree_text)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickNo(view: View) {
        Timber.i("onClickNo")
        viewModel.setDescriptionRes(dialog_ads_gdpr_disagree_text)
    }

    private fun openAdsGdpResult(@StringRes descriptionRes: Int) {
        Timber.i("openAdsGdpResult, descriptionRes = $descriptionRes")
        val action = openAdsResultDialog(descriptionRes = descriptionRes)
        findNavController().navigate(action)
    }


}