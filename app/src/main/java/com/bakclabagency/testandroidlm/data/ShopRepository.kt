package com.bakclabagency.testandroidlm.data

import com.bakclabagency.testandroidlm.data.model.ProductProvider
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.data.model.ShopProvider
import com.bakclabagency.testandroidlm.data.network.ShopService

class ShopRepository {
    private val api= ShopService()

    suspend fun getAllSop():List<ShopModel>{
        val response:List<ShopModel> = api.getInfoShop()
        ShopProvider.shop = response
        return response
    }


    suspend fun getAllProduct():List<ProductsModel>{
        val response:List<ProductsModel> = api.getInfoProduct()
        ProductProvider.product = response
        return response
    }

}