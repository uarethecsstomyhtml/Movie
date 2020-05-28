package com.example.android.movies.presentation.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.android.movies.R
import com.example.android.movies.presentation.MovieStatus
import com.example.android.movies.presentation.MovieStatus.*


data class MovieUi(
    val id: Long,
    val name: String,
    val status: MovieStatus,
//    val questionLetters: QuestionUiList,
//    val answerLetters: QuestionUiList
    val answerLetters: String

) {
    val nameUi = if (status == GUESSED) name else ""

    val nameColorUi = when (status) {
        GUESSED -> R.color.movie_is_guessed
        else -> R.color.white
    }

    val imgUi = when (status) {
        GUESSED -> R.drawable.ic_star_active
        OPEN -> R.drawable.ic_star_inactive
        CLOSED -> R.drawable.ic_lock
    }

}

@SuppressWarnings("Заглушка")
fun generateMovieUiList(): MutableList<MovieUi> {
    val list = mutableListOf<MovieUi>()
    list.add(
        MovieUi(
            id = 1,
            name = "Гарри Поттер",
            status = GUESSED,
            answerLetters = "сыеагертрафирптобр"
        )
    )
    list.add(
        MovieUi(
            id = 2,
            name = "Игра Престолов",
            status = GUESSED,
            answerLetters = "реиаиылпнвржогсвот"
        )
    )
    list.add(
        MovieUi(
            id = 3,
            name = "Звёздные войны",
            status = OPEN,
            answerLetters = "еынсздёмюоывзвуйнц"
        )
    )
    list.add(MovieUi(id = 4, name = "Титаник", status = OPEN, answerLetters = "этиьажтириыюьщклну"))
    list.add(MovieUi(id = 5, name = "Бригада", status = OPEN, answerLetters = "гсбцааоююэарсудьил"))
    list.add(
        MovieUi(
            id = 6,
            name = "Пираты карибского моря",
            status = CLOSED,
            answerLetters = "хбмгыпарилтюлоарояжосриккчя"
        )
    )
    list.add(
        MovieUi(
            id = 7,
            name = "Форсаж",
            status = CLOSED,
            answerLetters = "икартезнасомвтажфю"
        )
    )
    list.add(
        MovieUi(
            id = 8,
            name = "Крёстный отец",
            status = CLOSED,
            answerLetters = "зытйлтнцэнбеосрёпк"
        )
    )
    list.add(
        MovieUi(
            id = 9,
            name = "Сверхъестественное",
            status = CLOSED,
            answerLetters = "ссъесзвесщехяоелсвнръцюттен"
        )
    )
    list.add(
        MovieUi(
            id = 10,
            name = "Король лев",
            status = CLOSED,
            answerLetters = "фвоьилжролеанщькрв"
        )
    )
    list.add(MovieUi(id = 11, name = "Шрэк", status = CLOSED, answerLetters = "гажрэыэжпквючшкэьх"))
    list.add(
        MovieUi(
            id = 12,
            name = "Начало",
            status = CLOSED,
            answerLetters = "лызчалчшэоинбемабл"
        )
    )
    list.add(
        MovieUi(
            id = 13,
            name = "Шерлок",
            status = CLOSED,
            answerLetters = "руьгблибадпошешхкч"
        )
    )
    list.add(
        MovieUi(
            id = 14,
            name = "Мадагаскар",
            status = CLOSED,
            answerLetters = "ваоладаытдмыагарск"
        )
    )
    list.add(
        MovieUi(
            id = 15,
            name = "Охотники за привидениями",
            status = CLOSED,
            answerLetters = "итзиинрнщоекхдряпоанимвидти"
        )
    )
    list.add(
        MovieUi(
            id = 16,
            name = "Достучаться до небес",
            status = CLOSED,
            answerLetters = "нлтеьсасютедосгясьочодщубсс"
        )
    )
    list.add(
        MovieUi(
            id = 17,
            name = "Универ",
            status = CLOSED,
            answerLetters = "рщчиыовнуядьчелваз"
        )
    )
    list.add(
        MovieUi(
            id = 18,
            name = "Гладиатор",
            status = CLOSED,
            answerLetters = "огщлчжацарслчтщидя"
        )
    )
    list.add(
        MovieUi(
            id = 19,
            name = "Холодное сердце",
            status = CLOSED,
            answerLetters = "еедвсорпхерхгодшдлпцюлаэдон"
        )
    )
    list.add(
        MovieUi(
            id = 20,
            name = "Побег из тюрьмы",
            status = CLOSED,
            answerLetters = "зпмрбтьюмедоыиэнуг"
        )
    )
    list.add(
        MovieUi(
            id = 21,
            name = "Стражи галактики",
            status = CLOSED,
            answerLetters = "ржюцячрилкитстлжргиаабнзафк"
        )
    )
    list.add(
        MovieUi(
            id = 22,
            name = "Властелин колец",
            status = CLOSED,
            answerLetters = "говктицелааавишнзвюлеталшрс"
        )
    )
    list.add(
        MovieUi(
            id = 23,
            name = "Евротур",
            status = CLOSED,
            answerLetters = "нрсавпсдкоитарсшуе"
        )
    )
    list.add(
        MovieUi(
            id = 24,
            name = "Доктор Хаус",
            status = OPEN,
            answerLetters = "щтщдхпмаугкваоосщр"
        )
    )

    return list
}