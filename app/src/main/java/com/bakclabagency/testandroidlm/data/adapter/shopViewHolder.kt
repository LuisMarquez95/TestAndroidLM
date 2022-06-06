package com.bakclabagency.testandroidlm.data.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.R
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.domain.ShopCaseClient
import com.bumptech.glide.Glide

class  shopViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val nShop = view.findViewById<TextView>(R.id.tvNombre)
    val dShop = view.findViewById<TextView>(R.id.tvDireccion)
    val photho = view.findViewById<ImageView>(R.id.ivShop)


    fun render(shopModel: ShopModel){

         nShop.text = shopModel.name
        dShop.text = shopModel.address
        Glide.with(photho.context).load(shopModel.image).into(photho)
    }
}