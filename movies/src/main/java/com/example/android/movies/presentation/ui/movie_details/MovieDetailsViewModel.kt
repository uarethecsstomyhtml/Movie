package com.example.android.movies.presentation.ui.movie_details

import android.view.View
import android.view.View.GONE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.movies.presentation.ui.movie_details.answers.AnswerUi
import com.example.android.movies.presentation.ui.movie_details.help.HelpType
import com.example.android.movies.presentation.ui.movie_details.help.HelpType.*
import com.example.android.movies.presentation.ui.movie_details.questions.QuestionContainerUi
import com.example.android.movies.presentation.ui.movie_details.questions.QuestionUi
import timber.log.Timber

class MovieDetailsViewModel() : ViewModel() {

    private val _isPlayMusic = MutableLiveData<Boolean>().apply {
        value = false
    }
    val isPlayMusic: LiveData<Boolean>
        get() = _isPlayMusic

    private val _help = MutableLiveData<List<HelpType>>()
    val help: LiveData<List<HelpType>>
        get() = _help

    private val _answerLetters = MutableLiveData<List<AnswerUi>>()
    val answerLetters: LiveData<List<AnswerUi>>
        get() = _answerLetters

    private val _questionContainer = MutableLiveData<List<QuestionContainerUi>>()
    val questionsContainer: LiveData<List<QuestionContainerUi>>
        get() = _questionContainer

    private val _question = MutableLiveData<QuestionUi>()
    val question: LiveData<QuestionUi>
        get() = _question

    private val _answer = MutableLiveData<AnswerUi>()
    val answer: LiveData<AnswerUi>
        get() = _answer

    fun onClickPlayOrStopMusic() {
        _isPlayMusic.value = !isPlayMusic.value!!
    }

    fun loadHelp() {
        _help.value = listOf(ADDITIONAL_HELP, ASK_FRIENDS, SHOP, FREE_100COINS)
    }

    fun loadAnswerLetters() {
        Timber.i("loadAnswerLetters")
        _answerLetters.value = listOf(
            AnswerUi(1, "A", "#6EC5FF"),
            AnswerUi(2, "B", "#6EC5FF"),
            AnswerUi(3, "C", "#6EC5FF"),
            AnswerUi(4, "D", "#6EC5FF"),
            AnswerUi(5, "E", "#6EC5FF"),
            AnswerUi(6, "F", "#6EC5FF"),
            AnswerUi(7, "G", "#6EC5FF"),
            AnswerUi(8, "H", "#6EC5FF"),
            AnswerUi(9, "i", "#6EC5FF"),
            AnswerUi(10, "J", "#6EC5FF"),
            AnswerUi(11, "K", "#6EC5FF"),
            AnswerUi(12, "L", "#6EC5FF"),
            AnswerUi(13, "M", "#6EC5FF"),
            AnswerUi(14, "N", "#6EC5FF"),
            AnswerUi(15, "O", "#6EC5FF"),
            AnswerUi(16, "P", "#6EC5FF"),
            AnswerUi(17, "Q", "#6EC5FF"),
            AnswerUi(18, "R", "#6EC5FF")
        )
    }

    fun loadQuestionLetters() {
        Timber.i("loadQuestionLetters")
        val questions = listOf(
            QuestionUi(1, "#000000"),
            QuestionUi(2, "#000000"),
            QuestionUi(3, "#000000"),
            QuestionUi(4, "#000000"),
            QuestionUi(5, "#000000"),
            QuestionUi(6, "#000000"),
            QuestionUi(7, "#000000"),
            QuestionUi(8, "#000000"),
            QuestionUi(9, "#000000")
            //QuestionUi(10,  "#000000"),
            //QuestionUi(11,  "#000000"),
            //QuestionUi(12, "#000000"),
            //QuestionUi(13,  "#000000")
        )
        val questions2 = listOf(
            QuestionUi(11, "#000000"),
            QuestionUi(12, "#000000"),
            QuestionUi(13, "#000000"),
            QuestionUi(14, "#000000"),
            QuestionUi(15, "#000000"),
            QuestionUi(16, "#000000"),
            QuestionUi(17, "#000000"),
            QuestionUi(18, "#000000"),
            QuestionUi(19, "#000000")
        )


        _questionContainer.value =
            listOf(QuestionContainerUi(1, questions), QuestionContainerUi(2, questions2))
    }

    fun findFirstQuestionEmptyLetter(answerUi: AnswerUi, answerPosition: Int) {
        Timber.i("findFirstQuestionEmptyLetter, answerUi = $answerUi")
        questionsContainer.value?.forEachIndexed { row, questionContainer ->
            questionContainer.questions.forEachIndexed { position, questionUi ->
                Timber.i("position = $position")
                if (questionUi.answer == null) {
                    Timber.i("questionUi.answer is null")
                    answerUi.questionId = questionUi.id
                    answerUi.isShowLetter = GONE
                    answerUi.position = answerPosition
                    questionUi.answer = answerUi
                    questionUi.rowUpdate = row
                    questionUi.positionUpdate = position
                    _question.value = questionUi
                    return
                }
            }

        }

    }

    fun findAnswerLetterByQuestionId(questionUi: QuestionUi): QuestionUi? {
        Timber.i("findAnswerLetterByQuestionId, questionUi = $questionUi")
        val answer = answerLetters.value?.find { it.questionId == questionUi.id }
        if (answer != null) {
            answer.questionId = 0L
            answer.isShowLetter = View.VISIBLE
            questionUi.answer = null
            _answer.value = answer
        }

        return null
    }

    fun clearQuestionRowAndPosition(questionUi: QuestionUi) {
        questionUi.positionUpdate = 0
        questionUi.rowUpdate = 0
    }


}