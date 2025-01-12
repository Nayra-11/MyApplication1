package com.example.myapplication1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication1.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding   View binding

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val users = mutableListOf(
            User("Ahmed Mohamed", "Ahmed@gmail.com"),
            User("Mahmoud Mohamed", "Mahmoud@gmail.com"),
            User("Mona Ahmed", "Mona@gmail.com"),
            User("Menna Ali", "Menna@gmail.com"),
            User("Youssef Mohamed", "Youssef@gmail.com"),
            User("Ahmed Mohamed", "Ahmed@gmail.com"),
            User("Mahmoud Ahmed", "Mahmoud@gmail.com"),
            User("Yasmine Ahmed", "Mona@gmail.com"),
            User("Mohamed Ali", "Menna@gmail.com"),
            User("Farida Mohamed", "Youssef@gmail.com")
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
                    Toast.makeText(this,R.string.change_lang, Toast.LENGTH_SHORT).show()
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
}

