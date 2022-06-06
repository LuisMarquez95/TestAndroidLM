package com.bakclabagency.testandroidlm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://private-2a065d-testnapify.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}