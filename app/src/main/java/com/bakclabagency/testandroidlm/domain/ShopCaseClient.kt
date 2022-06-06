package com.bakclabagency.testandroidlm.domain

import com.bakclabagency.testandroidlm.data.ShopRepository
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.data.model.ShopProvider

class ShopCaseClient {
    private val repository = ShopRepository()

    suspend operator fun invoke():List<ShopModel>?{
        return  repository.getAllSop()
    }
}