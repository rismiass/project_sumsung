package com.example.project

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import com.example.project.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //binding = ActivityRegisterBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_register)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val buttonBack = findViewById<Button>(R.id.back)
        buttonBack.setOnClickListener { finish() }
    }
}