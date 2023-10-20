package com.example.talabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talabt.databinding.ActivityLoginBinding
import com.example.talabt.databinding.ActivityMainBinding
import com.example.talabt.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.map.setOnClickListener {
            val intent = Intent(this, map::class.java)
            startActivity(intent)
        }
        binding.info.setOnClickListener {
            val intent = Intent(this, info::class.java)
            startActivity(intent)
        }
    }
}