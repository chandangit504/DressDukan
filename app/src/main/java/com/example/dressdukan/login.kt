package com.example.dressdukan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dressdukan.databinding.ActivityLoginBinding
import com.example.dressdukan.databinding.ActivitySignUpBinding

class login : AppCompatActivity() {

    val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

  binding.notHaveAccount.setOnClickListener(){
      startActivity(Intent(this,SignUp::class.java))
      finish()
  }
    }
}