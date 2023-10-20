package com.example.talabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talabt.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
         binding.signupButton.setOnClickListener{
             val email=binding.signupEmail.text.toString()
             val password=binding.signupPassword.text.toString()
             val confirmpassword=binding.signupConfirm.text.toString()
             if(email.isNotEmpty()&& password.isNotEmpty()&&confirmpassword.isNotEmpty()){
                 if(password==confirmpassword){
                     firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                         if(it.isSuccessful){
                             val intent=Intent(this,login::class.java)
                             startActivity(intent)
                         }
                         else{
                             Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                         }
                     }
                 }
                 else{
                     Toast.makeText(this, "passwords are not the same", Toast.LENGTH_SHORT).show()
                 }
             }
             else{
                 Toast.makeText(this, "please fill the requiremnts", Toast.LENGTH_SHORT).show()
             }
            binding.loginRedirectText.setOnClickListener{
                val loginintent=Intent(this,login::class.java)
                startActivity(loginintent)
            }
         }
    }
}