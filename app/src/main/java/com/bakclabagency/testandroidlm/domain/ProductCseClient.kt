package com.bakclabagency.testandroidlm.domain

import com.bakclabagency.testandroidlm.data.ShopRepository
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel

class ProductCseClient {
    private val repository = ShopRepository()

    suspend operator fun invoke():List<ProductsModel>?{
        return  repository.getAllProduct()
    }
}