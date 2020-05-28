package com.example.android.movies.presentation.ui.movie_details

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.media.AudioAttributesCompat.Builder
import androidx.media.AudioAttributesCompat.CONTENT_TYPE_MUSIC
import androidx.media2.common.MediaMetadata.*
import androidx.media2.common.UriMediaItem
import androidx.media2.player.MediaPlayer
import androidx.navigation.fragment.navArgs
import com.example.android.ads.DefaultBannerAd
import com.example.android.ads.DefaultInterstitialAd
import com.example.android.movies.R
import com.example.android.movies.presentation.ui.movie_details.answers.AnswerItem
import com.example.android.movies.presentation.ui.movie_details.questions.QuestionContainerItem
import com.example.android.movies.presentation.ui.movie_details.answers.AnswerUi
import com.example.android.movies.presentation.ui.movie_details.questions.QuestionContainerUi
import com.example.android.movies.presentation.ui.movie_details.questions.QuestionUi
import com.example.android.sound_components.SOUND_BACK_TO_MOVIE
import com.example.android.sound_components.SOUND_UI_TAP_NAME
import com.example.android.ui_components.BaseFragment
import com.example.android.ui_components.setSafeOnClickListener
import com.google.android.gms.ads.AdView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.content_media_player.*
import kotlinx.android.synthetic.main.content_movie_game.*
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber


class MovieDetailsFragment : BaseFragment(R.layout.fragment_movie_details) {

    private val args: MovieDetailsFragmentArgs by navArgs()
    private val viewModel: MovieDetailsViewModel by inject()

    private lateinit var defaultInterstitialAds: DefaultInterstitialAd
    private lateinit var adView: AdView

    private lateinit var questionsAdapter: GroupAdapter<GroupieViewHolder>
    private lateinit var answersAdapter: GroupAdapter<GroupieViewHolder>
    private lateinit var mediaPlayer: MediaPlayer

    private val soundBack: Int by inject(named(SOUND_BACK_TO_MOVIE))
    private val soundUiTap: Int by inject(named(SOUND_UI_TAP_NAME))

    override fun soundOnBackPressed() = soundBack

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.i("onViewCreated")
        setupInterstitialAds(view)
        setupQuestionsAdapter()
        setupAnswersAdapter()

        loadQuestions()
        loadAnswerLetters()

        setupMediaPlayer()
        //initSeekBarColor()
        setUpSeekbar()
        viewModel.isPlayMusic.observe(viewLifecycleOwner, Observer(::onStateMusicChange))
        viewModel.question.observe(viewLifecycleOwner, Observer(::onStateQuestionChange))
        viewModel.questionsContainer.observe(
            viewLifecycleOwner,
            Observer(::onStateQuestionsContainerChange)
        )
        viewModel.answer.observe(viewLifecycleOwner, Observer(::onStateAnswerChange))
        viewModel.answerLetters.observe(viewLifecycleOwner, Observer(::onStateAnswerLettersChange))

        showBannerAds()

        imgMusic.setSafeOnClickListener(soundUiTap, ::onClickImgMusic)
        imgShop.setSafeOnClickListener(soundUiTap, ::openShopDialog)
    }

    private fun loadQuestions() {
        viewModel.loadQuestionLetters()
    }

    private fun loadAnswerLetters() {
        viewModel.loadAnswerLetters()
    }

    private fun setupInterstitialAds(view: View) {
        Timber.i("setupInterstitialAds")
        adView = view.findViewById(R.id.adView)
        defaultInterstitialAds = DefaultInterstitialAd(requireContext())
        defaultInterstitialAds.initInterstitialAd()
    }

    // Now used test id.
    private fun showBannerAds() {
        Timber.d("showBannerAds")
        DefaultBannerAd.showBanner(adView)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun openShopDialog(view: View) {
        Timber.d("openShopDialog")
//        findNavController().navigate(R.id.shopDialog)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun openHintsDialog(view: View) {
        Timber.d("openHintsDialog")
//        findNavController().navigate(R.id.hintsDialog)
    }

    private fun setupMediaPlayer() {
        Timber.i("initMediaPlayer")
        mediaPlayer = MediaPlayer(requireContext()).apply {
            setMediaItem(getMediaItem())
            setAudioAttributes(Builder().setContentType(CONTENT_TYPE_MUSIC).build())
            prepare()
        }
    }

    private fun setUpSeekbar() {
        Timber.i(
            "setUpSeekbar ${mediaPlayer.currentMediaItem?.metadata?.getLong(
                METADATA_KEY_DURATION
            )?.toInt()}"
        )
        // seekBar.max = mediaPlayer.currentMediaItem?.endPosition?.toInt() ?: 0
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer.seekTo(progress * 1000L)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    // For testing
    private fun getMediaItem(): UriMediaItem {
        val file = "android.resource://${context?.packageName}/raw/mile_8"
        val mediaItem = UriMediaItem.Builder(Uri.parse(file)).build()
        val duration = mediaItem.metadata?.getLong(METADATA_KEY_DURATION)

        Timber.i("getMediaItem, duration = $duration")

        return mediaItem
    }

    private fun initSeekBarColor() {
        Timber.i("initSeekBarColor")
//        val colorBlue = ContextCompat.getColor(requireContext(), R.color.blue)
//        if (SDK_INT >= V29) setConfigSeekBarV29(colorBlue) else setConfigSeekBar(colorBlue)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun setConfigSeekBarV29(color: Int) {
        with(seekBar) {
//            progressDrawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
//            thumb.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_IN)
        }
    }

    @Suppress("DEPRECATION")
    private fun setConfigSeekBar(color: Int) {
        with(seekBar) {
//            progressDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
//            thumb.setColorFilter(color, PorterDuff.Mode.SRC_IN)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClickImgMusic(view: View) {
        Timber.i("onClickImgMusic")
        viewModel.onClickPlayOrStopMusic()
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

    private fun onStateQuestionChange(questionUi: QuestionUi) {
        Timber.i("onStateQuestionChange, questionUi = $questionUi")
        (questionsAdapter.getItem(questionUi.rowUpdate) as QuestionContainerItem).updateQuestionItem(
            questionUi
        )
    }

    private fun onStateQuestionsContainerChange(questionsContainer: List<QuestionContainerUi>) {
        for (item in questionsContainer) questionsAdapter.add(
            QuestionContainerItem(
                item,
                ::onQuestionClick
            )
        )
    }

    private fun onStateAnswerChange(answer: AnswerUi) {
        Timber.i("onStateAnswerChange, answer = $answer")
        answersAdapter.getItem(answer.position).notifyChanged(answer.isShowLetter)
    }

    private fun onStateAnswerLettersChange(answers: List<AnswerUi>) {
        Timber.i("onStateAnswerLettersChange, answers = $answers")
        for (answer in answers) answersAdapter.add(AnswerItem(answer, ::onAnswerClick))
    }

    private fun stopMusic() {
        Timber.i("stopMusic")
        mediaPlayer.pause()
        imgMusic.setImageResource(R.drawable.ic_music_play)
    }

    private fun getBgColor(): String {
        Timber.i("getBgColor: ${args.bgColor}")
        return args.bgColor
    }

    private fun setupQuestionsAdapter() {
        Timber.i("setupQuestionsAdapter")
        questionsAdapter = GroupAdapter()
        rvQuestions.adapter = questionsAdapter
    }

    private fun setupAnswersAdapter() {
        Timber.i("initAnswersAdapter")
        answersAdapter = GroupAdapter()
        rvAnswers.adapter = answersAdapter

    }

    private fun onQuestionClick(questionUi: QuestionUi) {
        Timber.i("onQuestionClick, questionUi = $questionUi")
        viewModel.findAnswerLetterByQuestionId(questionUi)
        (questionsAdapter.getItem(questionUi.rowUpdate) as QuestionContainerItem).updateQuestionItem(
            questionUi
        )
        viewModel.clearQuestionRowAndPosition(questionUi)
    }

    private fun onAnswerClick(answerUi: AnswerUi, position: Int) {
        Timber.i("onAnswerClick, answerUi = $answerUi, position = $position")
        viewModel.findFirstQuestionEmptyLetter(answerUi, position)
        answersAdapter.getItem(position).notifyChanged(answerUi)
//        item.notifyChanged(answerUi)
    }

    override fun onDestroy() {
        Timber.i("onDestroy")
        super.onDestroy()

        mediaPlayer.reset()
    }

}
