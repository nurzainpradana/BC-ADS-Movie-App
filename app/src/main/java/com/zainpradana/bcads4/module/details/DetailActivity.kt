package com.zainpradana.bcads4.module.details

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.zainpradana.bcads4.R
import com.zainpradana.bcads4.model.FilmModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<FilmModel>("data")

        if (data != null) {
            tv_title_detail.text = data.judul
            tv_genre.text = data.genre
            tv_desc.text = data.desc

            val mediaConstroller = MediaController(this)
            mediaConstroller.setAnchorView(videoView)
            videoView.setMediaController(mediaConstroller)

            videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + data.trailer))
            videoView.start()
        }


    }
}