package com.zainpradana.bcads4.module.details

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.zainpradana.bcads4.R
import com.zainpradana.bcads4.database.DatabaseContract
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.DESC
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.GENRE
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.POSTER
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.RATING
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TITLE
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TRAILER
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion._ID
import com.zainpradana.bcads4.database.MovieHelper
import com.zainpradana.bcads4.model.FilmModel
import com.zainpradana.bcads4.module.login.LoginActivity
import com.zainpradana.bcads4.utils.Const.CODE_LOGIN
import com.zainpradana.bcads4.utils.UserPreference
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    lateinit var data: FilmModel
    lateinit var noteHelper: MovieHelper
    private var statusFavorite = false
    lateinit var userPreference: UserPreference

    private var values = ContentValues()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        data = intent.getParcelableExtra<FilmModel>("data")!!

        userPreference = UserPreference(this)

        noteHelper = MovieHelper.getInstance(this)
        noteHelper.open()

        initView()
        initListener()

    }

    private fun initListener() {
        val mediaConstroller = MediaController(this)
        mediaConstroller.setAnchorView(videoView)
        videoView.setMediaController(mediaConstroller)

        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + data.trailer))
        videoView.start()

        iv_favorite.setOnClickListener {

            if (userPreference.getStatusUser()) {

                if (statusFavorite) {
                    noteHelper.deleteById(data.id.toString())
                    iconFavorite(false)
                } else {
                    values.put(_ID, data.id)
                    values.put(TITLE, data.judul)
                    values.put(DESC, data.desc)
                    values.put(GENRE, data.genre)
                    values.put(POSTER, data.poster)
                    values.put(TRAILER, data.trailer)
                    values.put(RATING, data.rating)

                    noteHelper.insert(values)

                    iconFavorite(true)
                }
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivityForResult(intent, CODE_LOGIN)
            }
        }
    }

    fun iconFavorite(boolean: Boolean) {
        if (boolean){
            statusFavorite = true
            iv_favorite.setImageResource(R.drawable.ic_favorite)
        } else {
            statusFavorite = false
            iv_favorite.setImageResource(R.drawable.ic_favorite_border_disable)
        }
    }

    fun statusFavorite() {
        var cursor = noteHelper.queryById(data.id.toString())
        if (cursor.moveToNext()) {
            iconFavorite(true)
        } else {
            iconFavorite(false)
        }
    }

    private fun initView() {
        tv_title_detail.text = data.judul
        tv_genre.text = data.genre
        tv_desc.text = data.desc

        statusFavorite()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, bundle: Intent?) {
        super.onActivityResult(requestCode, resultCode, bundle)

        if (requestCode == CODE_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                if (statusFavorite) {
                    noteHelper.deleteById(data.id.toString())
                    iconFavorite(false)
                } else {
                    values.put(_ID, data.id)
                    values.put(TITLE, data.judul)
                    values.put(DESC, data.desc)
                    values.put(GENRE, data.genre)
                    values.put(POSTER, data.poster)
                    values.put(TRAILER, data.trailer)
                    values.put(RATING, data.rating)

                    noteHelper.insert(values)

                    iconFavorite(true)
                }
            }
        }
    }
}