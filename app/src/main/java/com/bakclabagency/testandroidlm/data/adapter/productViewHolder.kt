package com.bakclabagency.testandroidlm.data.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.R
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bumptech.glide.Glide

class productViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val nShop = view.findViewById<TextView>(R.id.tvNombreSP)
    val dShop = view.findViewById<TextView>(R.id.tvDescrip)
    val price = view.findViewById<TextView>(R.id.tvPrice)


    fun render(productsModel: ProductsModel){

        nShop.text = productsModel.name
        dShop.text = productsModel.description
        price.text = productsModel.price.toString()
    }
}