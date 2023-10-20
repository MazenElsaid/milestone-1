package com.example.talabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talabt.databinding.ActivityLoginBinding
import com.example.talabt.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()
        binding.loginButton.setOnClickListener{
            val email =binding.loginEmail.text.toString()
            val password =binding.loginPassword.text.toString()
            if(email.isNotEmpty()&& password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent=Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this, "fields are empty pkease fill", Toast.LENGTH_SHORT).show()
            }
        }
        binding.signupRedirectText.setOnClickListener {
            val signupintent=Intent(this,signup::class.java)
            startActivity(signupintent)
        }
    }
}