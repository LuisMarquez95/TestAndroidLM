package com.bakclabagency.testandroidlm.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.R
import com.bakclabagency.testandroidlm.data.model.ShopModel

class shopAdapter(private val shopList:List<ShopModel>) : RecyclerView.Adapter<shopViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return shopViewHolder(layoutInflater.inflate(R.layout.tiendas_item, parent, false))
    }

    override fun onBindViewHolder(holder: shopViewHolder, position: Int) {
        val item = shopList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = shopList.size

}