package app

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.project.databinding.ActivityHomeBinding
import android.graphics.drawable.ColorDrawable
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.ui.NavigationUI
import com.example.project.R


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00000000")))
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(false)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        var bar = binding.progressBar
        bar.visibility = ProgressBar.VISIBLE
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView


        Singletons.init(applicationContext)
        val navController = findNavController(R.id.nav_host_fragment_activity_home)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this,navController)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        bar.visibility = ProgressBar.INVISIBLE
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment_activity_home)
        return navController.navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            Toast.makeText(applicationContext, "??????????????????", Toast.LENGTH_SHORT).show()
            return NavigationUI.onNavDestinationSelected(item, this.findNavController(R.id.nav_host_fragment_activity_home))
                    || super.onOptionsItemSelected(item)

    }

}