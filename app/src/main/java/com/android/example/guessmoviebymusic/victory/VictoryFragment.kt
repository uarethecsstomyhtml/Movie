package com.android.example.guessmoviebymusic.victory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.base.presentation.MainActivity.Companion.BASE_LINK_GOOGLE_PLAY_SITE
import com.android.example.guessmoviebymusic.extension.getDrawableVectorRes
import com.android.example.guessmoviebymusic.extension.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_victory.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class VictoryFragment : Fragment(R.layout.fragment_victory) {

    private lateinit var linkGooglePlay: String
    private val viewModel: VictoryViewModel by inject()

    companion object {
        private const val VK_REQUEST_CODE = 100
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated")
        fillMovieName()
        setLinkGooglePlay()
        setVkDrawable()
        setShareAppDrawable()
        setContinueDrawable()

        tvShareApp.setSafeOnClickListener(::onClickShareApp)
        layoutShareVk.setSafeOnClickListener(::onClickShareVk)
        tvContinue.setSafeOnClickListener(::onClickContinue)
        getCountStars()
        observeCountStars()
    }

    private fun getCountStars() {
        Timber.d("getCountStars")
        viewModel.getCountStars()
    }

    private fun observeCountStars() {
        Timber.d("observeCountStars")
        viewModel.countStars.observe(this, Observer(::stateCountStars))
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
    private fun onClickShareVk(view: View) {
        Timber.d("onClickShareVk")
        openShareVk()
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickContinue(view: View) {
        Timber.d("onClickContinue")
        activity?.finish() // Change
    }

    private fun getMovieName() = "Гарри Поттер"

    private fun setLinkGooglePlay() {
        Timber.d("setLinkGooglePlay")
        linkGooglePlay = "$BASE_LINK_GOOGLE_PLAY_SITE${context?.packageName}"
    }


    private fun setShareAppDrawable() {
        Timber.d("setShareAppDrawable")
        val drawable = context?.getDrawableVectorRes(R.drawable.ic_share_app)
        tvShareApp.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null)
    }

    private fun setVkDrawable() {
        Timber.d("setVkDrawable")
        val drawable = context?.getDrawableVectorRes(R.drawable.ic_share_vk)
        tvVkDescription.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
    }

    private fun setContinueDrawable() {
        Timber.d("setContinueDrawable")
        val drawable = context?.getDrawableVectorRes(R.drawable.ic_arrow_forward)
        tvContinue.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null)
    }

    private fun fillMovieName() {
        Timber.d("fillMovieName")
        tvMovieName.text = getMovieName()
    }

    private fun openShareApp() {
        Timber.d("openShareApp")
        val shareAppTitle = getString(R.string.fragment_victory_share_app_title)
        startActivity(Intent.createChooser(getShareAppIntent(), shareAppTitle))
//        fbAnalyticsShareApp()
    }

    private fun openShareVk() {
        Timber.d("openShareVk")
//        fbAnalyticsShareVk()
        val shareAppTitle = getString(R.string.fragment_victory_share_app_title)
        startActivityForResult(Intent.createChooser(getShareAppIntent(), shareAppTitle), VK_REQUEST_CODE)
    }

    private fun openRateAppDialog() {
        Timber.d("openRateAppDialog")
        findNavController().navigate(R.id.rateAppDialog)
    }

    private fun getShareAppIntent(): Intent {
        Timber.d("getShareAppIntent")
        val shareBody = getString(R.string.fragment_victory_share_app_description, getMovieName(), linkGooglePlay)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, shareBody)

        return intent
    }
}