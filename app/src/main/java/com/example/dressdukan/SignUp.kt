package com.example.dressdukan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.dressdukan.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.database


class SignUp : AppCompatActivity() {
    val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.HaveAccount.setOnClickListener() {
            startActivity(Intent(this, login::class.java))
            finish()
        }


        binding.signUpBtn.setOnClickListener{
            Firebase.auth.createUserWithEmailAndPassword(binding.Email.text.toString(),
                binding.pass.text.toString() ).addOnCompleteListener{
                if (it.isSuccessful){
                    var userModel = UserModel(binding.firstname.text.toString(),
                        binding.lastName.text.toString(),
                        binding.Email.text.toString(),
                        binding.pass.text.toString())

                    Firebase.database.reference.child("Users").child(it.result.user!!.uid).setValue(userModel).
                    addOnSuccessListener {
                        startActivity(Intent(this, buttom::class.java))
                        Toast.makeText(this, "User created", Toast.LENGTH_LONG).show()
                    }.addOnFailureListener {
                        Toast.makeText(this, it?.localizedMessage, Toast.LENGTH_LONG).show()
                    }
                }
                else{
                    Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}