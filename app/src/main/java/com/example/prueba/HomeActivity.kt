package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.prueba.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.activityHomeToolbarImage.setOnClickListener {
            Log.d("Hola", "Hola")
        }

    val navController = findNavController(R.id.nav_host_home_fragment)
    val appBarConfiguration = AppBarConfiguration(setOf(
        R.id.homeFragment,
        R.id.locationFragment,
        R.id.specialistFragment,
        R.id.profileFragment    ))
    binding.activityHomeNavigateButton.setupWithNavController(navController)


}

    }
