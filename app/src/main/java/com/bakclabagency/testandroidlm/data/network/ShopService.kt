package com.bakclabagency.testandroidlm.data.network

import com.bakclabagency.testandroidlm.core.RetroFitHelper
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ShopService {
    private val retrofit = RetroFitHelper.getRetrofit()
    suspend fun getInfoShop():List<ShopModel>{
        return withContext(Dispatchers.IO){
            val response:Response<List<ShopModel>> = retrofit.create(ShopApiClient::class.java).getAllShipments()
            response.body() ?: emptyList()
        }
    }


    suspend fun getInfoProduct():List<ProductsModel>{
        return withContext(Dispatchers.IO){
            val response:Response<List<ProductsModel>> = retrofit.create(ShopApiClient::class.java).getAllproducts()

            response.body() ?: emptyList()
        }
    }
}