package com.android.example.guessmoviebymusic.movie_details

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.Q as V29
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.media.AudioAttributesCompat
import androidx.media2.common.MediaMetadata.*
import androidx.media2.common.UriMediaItem
import androidx.media2.player.MediaPlayer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.example.guessmoviebymusic.*
import com.android.example.guessmoviebymusic.extension.setSafeOnClickListener
//import com.appodeal.ads.Appodeal
import kotlinx.android.synthetic.main.content_media_player.*
import kotlinx.android.synthetic.main.content_movie_game.*
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private val args: MovieDetailsFragmentArgs by navArgs()

    private val viewModel: MovieDetailsViewModel by inject()
    private lateinit var questionsAdapter: QuestionsAdapter
    private lateinit var answersAdapter: AnswersAdapter
    private lateinit var mediaPlayer: MediaPlayer


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.i("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        initMediaPlayer()
        initQuestionsAdapter()
        initAnswersAdapter()
        initSeekBarColor()
        observeMusicState()
        setUpSeekbar()

        imgMusic.setSafeOnClickListener(::onClickImgMusic)
        imgHint.setSafeOnClickListener(::openHintsDialog)
        imgShop.setSafeOnClickListener(::openShopDialog)
    }

    private fun showBannerAds() {
//        activity?.let { Appodeal.show(it, Appodeal.BANNER_BOTTOM) }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun openShopDialog(view: View) {
        Timber.d("openShopDialog")
        findNavController().navigate(R.id.shopDialog)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun openHintsDialog(view: View) {
        Timber.d("openHintsDialog")
        findNavController().navigate(R.id.hintsDialog)
    }

    // For future
    private fun uriBuilderAudioTrack(): UriMediaItem {
        Timber.i("uriBuilderAudioTrack")
        val uri = Uri.parse("http://").buildUpon().build()
        return UriMediaItem.Builder(uri).build()
    }

    private fun initMediaPlayer() {
        Timber.i("initMediaPlayer")
        mediaPlayer = MediaPlayer(context!!).apply {
            setMediaItem(getMediaItem())
            setAudioAttributes(AudioAttributesCompat.Builder()
                .setContentType(AudioAttributesCompat.CONTENT_TYPE_MUSIC)
                .build())
            prepare()
        }
    }

    private fun setUpSeekbar() {
        Timber.i("setUpSeekbar ${mediaPlayer.currentMediaItem?.metadata?.getLong(METADATA_KEY_DURATION)?.toInt()}")
//        seekBar.max = mediaPlayer.currentMediaItem?.endPosition?.toInt()
    }

    // For testing
    private fun getMediaItem(): UriMediaItem {
        Timber.i("getMediaItem")
        val file = "android.resource://${context?.packageName}/raw/mile_8"
        val mediaItem =  UriMediaItem.Builder(Uri.parse(file)).build()
        val duration = mediaItem.metadata?.getLong(METADATA_KEY_DURATION)

        Timber.d("getMediaItem, dur $duration")
        return mediaItem
    }

    @Suppress("DEPRECATION")
    private fun initSeekBarColor() {
        Timber.i("initSeekBarColor")
        val colorBlue = ContextCompat.getColor(context!!, R.color.blue)
        if (SDK_INT >= V29) {
            seekBar.progressDrawable.colorFilter = BlendModeColorFilter(colorBlue, BlendMode.SRC_ATOP)
            seekBar.thumb.colorFilter = BlendModeColorFilter(colorBlue, BlendMode.SRC_IN)

        } else {
            seekBar.progressDrawable.setColorFilter(colorBlue, PorterDuff.Mode.SRC_ATOP);
            seekBar.thumb.setColorFilter(colorBlue, PorterDuff.Mode.SRC_IN)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickImgMusic(view: View) {
        Timber.i("onClickImgMusic")
        viewModel.onClickPlayOrStopMusic()
    }

    private fun observeMusicState() {
        Timber.i("observeMusicState")
        viewModel.isPlayMusic.observe(this, Observer(::onStateMusicChange) )
    }

    private fun onStateMusicChange(isPlayMusic: Boolean?) {
        Timber.i("onStateMusicChange")
        if (isPlayMusic!!) playMusic() else stopMusic()
    }

    private fun playMusic() {
        Timber.i("playMusic")
        mediaPlayer.play()
        imgMusic.setImageResource(R.drawable.ic_music_pause)
    }

    private fun stopMusic() {
        Timber.i("stopMusic")
        mediaPlayer.pause()
        imgMusic.setImageResource(R.drawable.ic_music_play)
    }

//    private fun getBgColor(): String {
//        Timber.i("getBgColor: ${args.bgColor}")
//        return args.bgColor
//    }

    private fun initQuestionsAdapter() {
        Timber.i("initQuestionsAdapter")
        questionsAdapter = QuestionsAdapter { }
        val list = mutableListOf<QuestionUi>()
        list.add(QuestionUi(1, "d", "#000000"))
        list.add(QuestionUi(2, "d", "#000000"))
        list.add(QuestionUi(3, "g", "#000000"))
        list.add(QuestionUi(4, "e", "#000000"))
        list.add(QuestionUi(5, "q", "#000000"))
        list.add(QuestionUi(5, "c", "#000000"))
        list.add(QuestionUi(5, "z", "#000000"))
        list.add(QuestionUi(5, "k", "#000000"))
        list.add(QuestionUi(5, "l", "#000000"))

        rvQuestions.adapter = questionsAdapter

        questionsAdapter.submitList(list)
    }

    private fun initAnswersAdapter() {
        Timber.i("initAnswersAdapter")
        answersAdapter = AnswersAdapter { }
        val list = mutableListOf<AnswerUi>()
        list.add(AnswerUi(1, "A", "#6EC5FF"))
        list.add(AnswerUi(2, "B", "#6EC5FF"))
        list.add(AnswerUi(3, "C", "#6EC5FF"))
        list.add(AnswerUi(4, "D", "#6EC5FF"))
        list.add(AnswerUi(5, "E", "#6EC5FF"))
        list.add(AnswerUi(5, "F", "#6EC5FF"))
        list.add(AnswerUi(5, "G", "#6EC5FF"))
        list.add(AnswerUi(5, "H", "#6EC5FF"))
        list.add(AnswerUi(5, "i", "#6EC5FF"))
        list.add(AnswerUi(5, "J", "#6EC5FF"))
        list.add(AnswerUi(5, "K", "#6EC5FF"))
        list.add(AnswerUi(5, "L", "#6EC5FF"))
        list.add(AnswerUi(5, "M", "#6EC5FF"))
        list.add(AnswerUi(5, "N", "#6EC5FF"))
        list.add(AnswerUi(5, "O", "#6EC5FF"))
        list.add(AnswerUi(5, "P", "#6EC5FF"))
        list.add(AnswerUi(5, "Q", "#6EC5FF"))
        list.add(AnswerUi(5, "R", "#6EC5FF"))

        rvAnswers.adapter = answersAdapter
        answersAdapter.submitList(list)

    }

    private fun onQuestionClick(item: QuestionUi) {

    }

    private fun onAnswerClick(item: AnswerUi) {

    }

    override fun onDestroy() {
        Timber.i("onDestroy")
        super.onDestroy()
//        activity?.let { Appodeal.hide(it, Appodeal.BANNER) }

        mediaPlayer.reset()
    }

    override fun onResume() {
        Timber.i("onDestroy")
        super.onResume()
//        activity?.let { Appodeal.onResume(it, Appodeal.BANNER_TOP) }
    }
}
