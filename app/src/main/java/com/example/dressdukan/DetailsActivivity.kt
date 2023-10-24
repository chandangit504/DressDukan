package com.example.dressdukan

import ProductModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.dressdukan.databinding.ActivityDetailsActivivityBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class DetailsActivivity : AppCompatActivity() {

    val binding by lazy {

        ActivityDetailsActivivityBinding.inflate(layoutInflater)
    }
    var productModel = ProductModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        var productID = intent.getStringExtra("PRODUCT_ID")
         var productImage = intent.getStringExtra("IMAGE_URl")
        Firebase.firestore.collection("Products").document(productID!!).get().addOnSuccessListener {

            productModel = it.toObject<ProductModel>()!!
            productModel.id = it.id
            binding.productimage.load(productImage)
        }

    }

}