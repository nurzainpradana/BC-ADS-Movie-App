package com.zainpradana.bcads4.module.home

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.bcads4.module.wishlist.AllMovieActivity
import com.zainpradana.bcads4.R
import com.zainpradana.bcads4.adapter.MovieAdapter
import com.zainpradana.bcads4.api.DummyData
import com.zainpradana.bcads4.model.FilmModel
import com.zainpradana.bcads4.module.details.DetailActivity
import com.zainpradana.bcads4.module.login.LoginActivity
import com.zainpradana.bcads4.utils.Const
import com.zainpradana.bcads4.utils.Const.CODE_LOGIN
import com.zainpradana.bcads4.utils.UserPreference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var dataList = ArrayList<FilmModel>()
    lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userPreference = UserPreference(this)
        rv_shimmer.startShimmerAnimation()

        var handler = Handler()
        handler.postDelayed({
            rv_shimmer.stopShimmerAnimation()
            rv_shimmer.visibility = View.GONE
            rv_movie.visibility = View.VISIBLE
            initListener()
            getData()
        }, 5000)


    }

    private fun initListener() {
        tv_user.setOnClickListener {
            if (userPreference.getStatusUser()){
                //List Data Yang Udah Di Save

            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivityForResult(intent, CODE_LOGIN)
            }

        }
    }

    private fun initView() {
        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

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

        if (userPreference.getStatusUser()) {
            tv_user.text = userPreference.getNamaUser()
            tv_desc_user.text = "Thanks for Join, do you want exit ?"
            //tv_favorite_size.text = dataOffline.size.toString()
            btn_logout.visibility = View.VISIBLE
        } else {
            tv_user.text = "Login"
            tv_desc_user.text = "Save Your Favorite Movie"
            btn_logout.visibility = View.INVISIBLE
        }

    }


    fun getData() {
        for ( i in DummyData.titleMovie.indices) {
            dataList.add(FilmModel(
                i + 1,
                DummyData.titleMovie[i],
                DummyData.descMovie[i],
                DummyData.genreMovie[i],
                DummyData.posterMovie[i],
                DummyData.trailerMovie[i],
                DummyData.ratingMovie[i]
                )
            )
        }
        initView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {

            }
        }
    }

    override fun onResume() {
        super.onResume()

        initView()
    }
}