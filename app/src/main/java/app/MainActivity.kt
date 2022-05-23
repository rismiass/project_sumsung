package app

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.Toast
import android.content.Intent
import android.widget.EditText
import app.model.accounts.AccountRepository
import com.example.project.R
import com.example.project.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val accountsRepository: AccountRepository = Singletons.accountsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val buttonRegister = findViewById<Button>(R.id.register)
        buttonRegister.setOnClickListener {
            b()
            //
            Toast.makeText(applicationContext, "Регистрация", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
        val buttonEntrance = findViewById<Button>(R.id.entrance)
        //val buttonEntrance = binding.entrance
        buttonEntrance.setOnClickListener {
            Toast.makeText(applicationContext, "Вход", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun b() = runBlocking{
        val token = accountsRepository.signIn(binding.phoneEmail.text.toString(), binding.password.text.toString())
        print(token)
    }
}