package com.android.example.guessmoviebymusic.movies.presentation

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.android.example.guessmoviebymusic.R
import com.android.example.guessmoviebymusic.`typealias`.movieUiClick
import com.android.example.guessmoviebymusic.extension.inflate
import com.android.example.guessmoviebymusic.extension.setSafeOnClickListener
import com.android.example.guessmoviebymusic.movies.presentation.MoviesAdapter.MoviesViewHolder
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(
        private val bgColor: String,
        private val clickListener: movieUiClick
) : ListAdapter<MovieUi, MoviesViewHolder>(MovieUi.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(item = getItem(position), bgColor = bgColor, clickListener = clickListener)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MovieUi, bgColor: String, clickListener: movieUiClick) {
            with(itemView) {
                setBackgroundColor(Color.parseColor(bgColor))
                movieName.text = item.name
                setSafeOnClickListener { clickListener(item) }
            }
//            itemView.movieImg.setImageResource(item.imgRes) // Release
            if (adapterPosition == 0) itemView.movieImg.setImageResource(R.drawable.ic_star_empty) // Test
            else itemView.movieImg.setImageResource(R.drawable.ic_star2) // Test
            // new Movie(id=1, name="Гарри Поттер", answerLetters="сыеагертрафирптобр")
// new Movie(id=2, name="Игра Престолов", answerLetters="реиаиылпнвржогсвот")
// new Movie(id=3, name="Звёздные войны", answerLetters="еынсздёмюоывзвуйнц")
// new Movie(id=4, name="Титаник", answerLetters="этиьажтириыюьщклну")
// new Movie(id=5, name="Бригада", answerLetters="гсбцааоююэарсудьил")
// new Movie(id=6, name="Пираты карибского моря", answerLetters="хбмгыпарилтюлоарояжосриккчя")
// new Movie(id=7, name="Форсаж", answerLetters="икартезнасомвтажфю")
// new Movie(id=8, name="Крёстный отец", answerLetters="зытйлтнцэнбеосрёпк")
// new Movie(id=9, name="Сверхъестественное", answerLetters="ссъесзвесщехяоелсвнръцюттен")
// new Movie(id=10, name="Король лев", answerLetters="фвоьилжролеанщькрв")
// new Movie(id=11, name="Шрэк", answerLetters="гажрэыэжпквючшкэьх")
// new Movie(id=12, name="Начало", answerLetters="лызчалчшэоинбемабл")
// new Movie(id=13, name="Шерлок", answerLetters="руьгблибадпошешхкч")
// new Movie(id=14, name="Мадагаскар", answerLetters="ваоладаытдмыагарск")
// new Movie(id=15, name="Охотники за привидениями", answerLetters="итзиинрнщоекхдряпоанимвидти")
// new Movie(id=16, name="Достучаться до небес", answerLetters="нлтеьсасютедосгясьочодщубсс")
// new Movie(id=17, name="Универ", answerLetters="рщчиыовнуядьчелваз")
// new Movie(id=18, name="Гладиатор", answerLetters="огщлчжацарслчтщидя")
// new Movie(id=19, name="Холодное сердце", answerLetters="еедвсорпхерхгодшдлпцюлаэдон")
// new Movie(id=20, name="Побег из тюрьмы", answerLetters="зпмрбтьюмедоыиэнуг")
// new Movie(id=21, name="Стражи галактики", answerLetters="ржюцячрилкитстлжргиаабнзафк")
// new Movie(id=22, name="Властелин колец", answerLetters="говктицелааавишнзвюлеталшрс")
// new Movie(id=23, name="Евротур", answerLetters="нрсавпсдкоитарсшуе")
// new Movie(id=24, name="Доктор Хаус", answerLetters="щтщдхпмаугкваоосщр")


            
        }

        companion object {
            fun from(parent: ViewGroup) = MoviesViewHolder(parent.inflate(R.layout.item_movie))
        }
    }
}
