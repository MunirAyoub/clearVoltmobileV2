package com.example.clearvolt.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.clearvolt.R
import com.example.clearvolt.databinding.ActivityNavigationBinding
import com.google.firebase.auth.FirebaseAuth

class NavigationActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNavigationBinding.inflate(layoutInflater)
    }
    private val authenticate by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.navigationBar.setupWithNavController(navController)
    }
}