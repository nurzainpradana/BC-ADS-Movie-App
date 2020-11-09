package com.zainpradana.bcads4.module.wishlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.bcads4.R
import com.zainpradana.bcads4.adapter.AllMovieAdapter
import com.zainpradana.bcads4.database.MovieHelper
import com.zainpradana.bcads4.model.FilmModel
import com.zainpradana.bcads4.module.details.DetailActivity
import com.zainpradana.bcads4.utils.MappingHelper
import kotlinx.android.synthetic.main.content_all_movie.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class WishlistActivity : AppCompatActivity() {

    private var dataList = ArrayList<FilmModel>()
    lateinit var noteHelper: MovieHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movie)
        setSupportActionBar(findViewById(R.id.toolbar))

        noteHelper = MovieHelper.getInstance(this)
        noteHelper.open()
    }

    fun getData(){
        GlobalScope.launch(Dispatchers.Main) {
            val defferdValue = async(Dispatchers.IO) {
                var cursor = noteHelper.queryAll()
                MappingHelper.mapCursorToArrayList(cursor)
            }
            dataList = defferdValue.await()
            initView()
        }
    }

    fun initView() {
        rv_all_movie.layoutManager = LinearLayoutManager(this)

        rv_all_movie.adapter = AllMovieAdapter(dataList){
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }
    }
}