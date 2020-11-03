package com.zainpradana.bcads4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.zainpradana.bcads4.module.home.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
        }, 5000)
    }
}