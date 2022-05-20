package app

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.project.R

class RegisterActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        //binding = ActivityRegisterBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_register)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val buttonBack = findViewById<Button>(R.id.back)
        buttonBack.setOnClickListener { finish() }
    }
}