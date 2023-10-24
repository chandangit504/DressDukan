package com.example.dressdukan

import ProductModel
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dressdukan.databinding.ProductitemBinding

class productAdapter(var contex: Context, var productlist: ArrayList<ProductModel>) : RecyclerView.Adapter<productAdapter.Viewholder>() {


    inner class Viewholder(var binding: ProductitemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var binding = ProductitemBinding.inflate(LayoutInflater.from(contex), parent,false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int {
          return productlist.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        holder.binding.itemimage.load(productlist.get(position).imageurl){
            placeholder(R.drawable.baseline_download_24)        }
        holder.binding.itDesc.text= productlist.get(position).itemName
        holder.binding.itPrdkey.text= productlist.get(position).id
        holder.binding.price.text= productlist.get(position).price.toString()
        holder.binding.itemimage.setOnClickListener{
            contex.startActivity(Intent(contex, DetailsActivivity::class.java).
            putExtra("PRODUCT_ID", productlist.get(position).id).
            putExtra("IMAGE_URl", productlist.get(position).imageurl))
        }




    }

}