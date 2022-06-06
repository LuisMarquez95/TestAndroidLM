package com.bakclabagency.testandroidlm.ui.viewmodel

import android.renderscript.ScriptGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.domain.ProductCseClient
import com.bakclabagency.testandroidlm.domain.ShopCaseClient
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    val productModel = MutableLiveData<ProductsModel>()
    val getProducts = ProductCseClient()

    fun onStartDash(){
        viewModelScope.launch {
            val result:List<ProductsModel>?= getProducts()

            if(!result.isNullOrEmpty()){
                productModel.postValue(result!!)

            }


        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"


    }
    val text: LiveData<String> = _text




}

private fun <T> MutableLiveData<T>.postValue(result: List<ProductsModel>) {

}


