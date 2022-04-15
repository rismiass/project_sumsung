package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.ActionBar

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}