package com.example.myapplication1

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication1.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding   View binding

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val users = mutableListOf(
            User("Group1", "", 2),
            User("Ahmed Mohamed", "Ahmed@gmail.com", 1),
            User("Mahmoud Mohamed", "Mahmoud@gmail.com",1),
            User("Mona Ahmed", "Mona@gmail.com",1),
            User("Menna Ali", "Menna@gmail.com",1),
            User("Group2", "", 2),
            User("Youssef Mohamed", "Youssef@gmail.com",1),
            User("Ahmed Mohamed", "Ahmed@gmail.com",1),
            User("Mahmoud Ahmed", "Mahmoud@gmail.com",1),
            User("Group3", "", 2),
            User("Yasmine Ahmed", "Mona@gmail.com",1),
            User("Mohamed Ali", "Menna@gmail.com",1),
            User("Farida Mohamed", "Youssef@gmail.com",1)
        )

        val userAdapter = UserAdapter(users)

        binding.rvStudents.adapter = userAdapter

        binding.toolbarLayout.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> {
                    Toast.makeText(this,R.string.home,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.gallery -> {
                    Toast.makeText(this,R.string.gallery,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.slideShow -> {
                    Toast.makeText(this,R.string.slide_show,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }

        binding.toolbarLayout.toolbar.setOnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.search -> {
                    Toast.makeText(this,R.string.search, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this,R.string.profile, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this,R.string.settings, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.changeLanguage -> {
                    updateLocale(this,"ar")
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(this, R.string.home, Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.profile -> {
                    Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.settings -> {
                    Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }


    }

    fun updateLocale(context: Context, languageCode: String) {

        // locale  ar  direction

        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
            context.createConfigurationContext(config)
        } else {
            config.locale = locale
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }

        // Update layout direction
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale)
        }

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        //restart activity

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
