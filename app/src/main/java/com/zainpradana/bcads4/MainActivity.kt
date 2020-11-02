package com.zainpradana.bcads4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_all_movie.*

class MainActivity : AppCompatActivity() {
    private var dataList = ArrayList<FilmModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        loadDataSample()

        rv_movie.adapter = MovieAdapter(dataList){
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }

        tv_view_all.setOnClickListener {
            val intent = Intent(this, AllMovieActivity::class.java)
                .putExtra("data", dataList)
            startActivity(intent)
        }
    }

    private fun loadDataSample() {
        dataList.add(
            FilmModel(
                "1",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa indonesia. Bantu kami memperbaikinya",
                "Action",
                R.drawable.ic_ad_astra,
                R.raw.video_a_rainy_day,
                4.0F
            )
        )
        dataList.add(
            FilmModel(
                "2",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa indonesia. Bantu kami memperbaikinya",
                "Action",
                R.drawable.ic_avengers,
                R.raw.video_sample,
                5.0F
            )
        )
        dataList.add(
            FilmModel(
                "1",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa indonesia. Bantu kami memperbaikinya",
                "Action",
                R.drawable.ic_poster_sonic,
                R.raw.video_sonic,
                1.0F
            )
        )
        dataList.add(
            FilmModel(
                "2",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa indonesia. Bantu kami memperbaikinya",
                "Action",
                R.drawable.ic_avengers,
                R.raw.video_sonic,
                2.0F
            )
        )
        dataList.add(
            FilmModel(
                "1",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa indonesia. Bantu kami memperbaikinya",
                "Action",
                R.drawable.ic_poster_sonic,
                R.raw.video_sample,
                3.0F
            )
        )
    }
}