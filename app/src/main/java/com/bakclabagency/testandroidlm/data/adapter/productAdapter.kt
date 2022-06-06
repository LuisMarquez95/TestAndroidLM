package com.bakclabagency.testandroidlm.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.R
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel

class productAdapter(private val prodList:List<ProductsModel>) : RecyclerView.Adapter<productViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return productViewHolder(layoutInflater.inflate(R.layout.productos_card, parent, false))
    }



    override fun getItemCount(): Int = prodList.size

    override fun onBindViewHolder(holder: productViewHolder, position: Int) {
        val item = prodList[position]
        holder.render(item)
    }
}