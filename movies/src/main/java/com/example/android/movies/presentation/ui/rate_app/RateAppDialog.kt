package com.example.android.movies.presentation.ui.rate_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.android.movies.R
import com.example.android.sound_components.SOUND_CANCEL
import com.example.android.ui_components.setSafeOnClickListener
import kotlinx.android.synthetic.main.dialog_rate_app.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber

class RateAppDialog : DialogFragment() {

    private val soundCancel: Int by inject(named(SOUND_CANCEL))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return inflater.inflate(R.layout.dialog_rate_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated")
        super.onActivityCreated(savedInstanceState)
        setNotCancelledDialog()

        btnNotNow.setSafeOnClickListener(soundCancel, ::closeDialog)
        btnRate.setSafeOnClickListener(soundCancel, ::onClickRate)
    }

//    private fun linkGooglePlay(): String {
//        Timber.d("linkGooglePlay")
//        return "$BASE_LINK_GOOGLE_PLAY_SITE${context?.packageName}"
//    }

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
//        context?.openRateApp()
    }
}