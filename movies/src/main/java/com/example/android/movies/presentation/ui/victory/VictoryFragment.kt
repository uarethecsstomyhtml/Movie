package com.example.android.movies.presentation.ui.victory

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.android.movies.R
import com.example.android.sound_components.SOUND_ALERT_NAME
import com.example.android.sound_components.SOUND_UI_TAP_NAME
import com.example.android.ui_components.getDrawableVector
import com.example.android.ui_components.play
import com.example.android.ui_components.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_victory.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber

class VictoryFragment : Fragment(R.layout.fragment_victory) {

    private lateinit var linkGooglePlay: String
    private val viewModel: VictoryViewModel by inject()
    private val soundPool: SoundPool by inject()

    private val soundUiTap: Int by inject(named(SOUND_UI_TAP_NAME))
    private val soundAlert: Int by inject(named(SOUND_ALERT_NAME))


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated")
        fillMovieName()
        setLinkGooglePlay()
        setShareAppDrawable()
        setContinueDrawable()

        loadAmountCoins()

        tvShareApp.setSafeOnClickListener(soundUiTap, ::onClickShareApp)
        tvContinue.setSafeOnClickListener(soundUiTap, ::onClickContinue)
        getCountStars()
        viewModel.amountCoins.observe(viewLifecycleOwner, Observer(::changeAmountCoinsState))
        viewModel.countStars.observe(viewLifecycleOwner, Observer(::stateCountStars))

    }

    private fun loadAmountCoins() {
        Timber.d("loadAmountCoins")
        viewModel.loadAmountCoins()
    }

    private fun changeAmountCoinsState(amount: Int) {
        Timber.d("changeAmountCoinsState $amount")
        tvAmountCoins.text = "$amount"
    }

    private fun getCountStars() {
        Timber.d("getCountStars")
        viewModel.getCountStars()
    }

    private fun stateCountStars(countStars: Int) {
        Timber.d("stateCountStars")
        if (countStars % 3 == 0) openRateAppDialog()
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickShareApp(view: View) {
        Timber.d("onClickShareApp")
        openShareApp()
    }


    @Suppress("UNUSED_PARAMETER")
    private fun onClickContinue(view: View) {
        Timber.d("onClickContinue")
        soundPool.play(soundAlert)
        openRateAppDialog()

//        activity?.finish() // Change
    }

    private fun getMovieName() = "Гарри Поттер"

    private fun setLinkGooglePlay() {
        Timber.d("setLinkGooglePlay")
//        linkGooglePlay = "$BASE_LINK_GOOGLE_PLAY_SITE${context?.packageName}"
    }

    private fun setShareAppDrawable() {
        Timber.d("setShareAppDrawable")
        val drawable = context?.getDrawableVector(R.drawable.ic_share_app)
        tvShareApp.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null)
    }

    private fun setContinueDrawable() {
        Timber.d("setContinueDrawable")
        val drawable = context?.getDrawableVector(R.drawable.ic_continue)
        tvContinue.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null)
    }

    private fun fillMovieName() {
        Timber.d("fillMovieName")
        tvMovieName.text = getMovieName()
    }

    private fun openShareApp() {
        Timber.d("openShareApp")
        val shareAppTitle = getString(R.string.title_share_app)
        startActivity(Intent.createChooser(getShareAppIntent(), shareAppTitle))
//        fbAnalyticsShareApp()
    }


    private fun openRateAppDialog() {
        Timber.d("openRateAppDialog")
//        findNavController().navigate(R.id.rateAppDialog)
    }

    private fun getShareAppIntent(): Intent {
        Timber.d("getShareAppIntent")
//        val shareBody = getString(R.string.fragment_victory_share_app_description, getMovieName(), linkGooglePlay)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
//        intent.putExtra(Intent.EXTRA_TEXT, shareBody)

        return intent
    }
}