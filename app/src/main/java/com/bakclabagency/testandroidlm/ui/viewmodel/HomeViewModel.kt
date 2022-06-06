package com.bakclabagency.testandroidlm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.domain.ProductCseClient
import com.bakclabagency.testandroidlm.domain.ShopCaseClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val shopModel = MutableLiveData<ShopModel>()
    val getShop = ShopCaseClient()
    val isLoading = MutableLiveData<Boolean>()

    fun onStartHomeShop(){

        viewModelScope.launch {

            val result:List<ShopModel>?= getShop()



                if(!result.isNullOrEmpty()){
                    shopModel.postValue(result!!)

                }




        }
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _rv = MutableLiveData<ProductsModel>().apply {


    }
}



private fun <T> MutableLiveData<T>.postValue(result: List<ShopModel>) {

}

