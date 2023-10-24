package com.example.dressdukan

import ProductModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dressdukan.databinding.FragmentDashBoardBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject


class DashBoardFragment : Fragment() {
   private  lateinit var binding: FragmentDashBoardBinding
    private  lateinit var productlist: ArrayList<ProductModel>
    private lateinit var adapter: productAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productlist = ArrayList()
        adapter= productAdapter(requireContext(), productlist)
        binding.mainRv.adapter= adapter
        getProductData()
    }
    private fun getProductData() {

        Firebase.firestore.collection("Products").get().addOnSuccessListener {
            productlist.clear()
            for (i in it.documents) {
                var temvalue = i.toObject<ProductModel>()
                temvalue?.id= i.id
                productlist.add(temvalue!!)

                Toast.makeText(requireContext(), "run", Toast.LENGTH_LONG).show()
            }
          adapter.notifyDataSetChanged()

        }.addOnFailureListener {
            Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
    companion object{

    }
}