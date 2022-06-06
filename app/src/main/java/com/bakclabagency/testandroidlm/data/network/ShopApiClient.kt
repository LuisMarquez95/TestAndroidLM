package com.bakclabagency.testandroidlm.data.network

import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import retrofit2.Response
import retrofit2.http.GET

interface ShopApiClient {
    @GET("/establishments")
    suspend fun getAllShipments():Response<List<ShopModel>>

    @GET("/products")
    suspend fun getAllproducts():Response<List<ProductsModel>>
}