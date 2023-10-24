package com.example.dressdukan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun moveToLogin(view: View) {
        if (Firebase.auth== null){
            startActivity(Intent(this,login::class.java))
            finish()
        }
        else{
            startActivity(Intent(this,buttom::class.java))
            finish()
        }
    }

    fun mts(view: View) {}
}