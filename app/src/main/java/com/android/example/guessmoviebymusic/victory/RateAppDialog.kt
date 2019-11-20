package com.android.example.guessmoviebymusic.victory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.base.presentation.MainActivity.Companion.BASE_LINK_GOOGLE_PLAY_SITE
import com.android.example.guessmoviebymusic.extension.openRateApp
import kotlinx.android.synthetic.main.dialog_rate_app.*
import timber.log.Timber

class RateAppDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("onCreateView")
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return inflater.inflate(R.layout.dialog_rate_app, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("onCreateView")
        super.onActivityCreated(savedInstanceState)
        setNotCancelledDialog()

        btnNotNow.setOnClickListener(::closeDialog)
        btnRate.setOnClickListener(::onClickRate)
    }

    private fun linkGooglePlay(): String {
        Timber.d("linkGooglePlay")
        return "$BASE_LINK_GOOGLE_PLAY_SITE${context?.packageName}"
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickRate(view: View) {
        Timber.d("onClickRate")
        when {
            areNumberStarsEmpty() -> showErrorRateApp()
            areNumberStarsMore3() -> rateApp()
            else -> closeDialog(view)
        }
    }

    private fun showErrorRateApp() {
        Timber.d("showErrorRateApp")
//        view?.showSnackbarErrorByString("Нажмите на звёздочки")
    }

    private fun areNumberStarsEmpty(): Boolean {
        Timber.d("areNumberStarsMore3")
        return rbApp.rating == 0F
    }

    private fun areNumberStarsMore3(): Boolean {
        Timber.d("areNumberStarsMore3")
        return rbApp.rating > 3
    }

    @Suppress("UNUSED_PARAMETER")
    private fun closeDialog(view: View) {
        Timber.d("closeDialog")
        dismiss()
    }

    @SuppressWarnings("Replace for proper english name")
    private fun setNotCancelledDialog() {
        Timber.d("setNotCancelledDialog")
        isCancelable = false
    }

    // try -> catch(replace this)
    private fun rateApp() {
        Timber.d("rateApp")
        context?.openRateApp()
    }
}