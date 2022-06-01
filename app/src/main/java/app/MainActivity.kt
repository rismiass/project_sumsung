package app

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.Toast
import android.content.Intent
import android.widget.EditText
import app.Singletons.accountsRepository
import app.model.EmptyFieldException
import app.model.Field
import app.model.accounts.AccountRepository
import com.example.project.R
import com.example.project.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val buttonRegister = findViewById<Button>(R.id.register)
        buttonRegister.setOnClickListener {
            Toast.makeText(applicationContext, "Регистрация", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
        val buttonEntrance = findViewById<Button>(R.id.entrance)
        buttonEntrance.setOnClickListener {
            val flag = onSignInButtonPressed()
            if (flag) {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun onSignInButtonPressed(): Boolean {
        var flag = true
        try {
            viewModel.signIn(
                binding.phoneEmail.text.toString(),
                binding.password.text.toString()
            )

        } catch (e: EmptyFieldException) {
            flag = false
            Toast.makeText(
                applicationContext, viewModel.processEmptyFieldException(e),
                Toast.LENGTH_SHORT
            ).show()
        }
        print(flag)
        return true
    }
}