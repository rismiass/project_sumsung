package com.example.project

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityRegisterBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_register)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}