package com.zainpradana.bcads4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AllMovieAdapter(private var data: List<FilmModel>,
                      private val listener: (FilmModel) -> Unit)
    : RecyclerView.Adapter<AllMovieAdapter.MovieViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView: View = layoutInflater.inflate(R.layout.item_movie_vertical, parent, false)
        return MovieViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class MovieViewHolder(view : View) :RecyclerView.ViewHolder(view){
        private val tvtitle: TextView = view.findViewById(R.id.tv_title_detail)
        private val ivPoster: ImageView = view.findViewById(R.id.iv_poster_vertical)
        private val tvDesc: TextView = view.findViewById(R.id.tv_desc_vertical)
        private val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)

        //Menampilkan Data
        fun bindItem(data: FilmModel, listener: (FilmModel) -> Unit, context: Context, position: Int){
            tvtitle.text = data.judul
            tvDesc.text = data.desc

            ratingBar.rating = data.rating

            Glide.with(context)
                .load(data.poster)
                .into(ivPoster)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}