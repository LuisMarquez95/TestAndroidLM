package com.bakclabagency.testandroidlm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.R
import com.bakclabagency.testandroidlm.core.RetroFitHelper.getRetrofit
import com.bakclabagency.testandroidlm.data.ShopRepository
import com.bakclabagency.testandroidlm.data.adapter.productAdapter
import com.bakclabagency.testandroidlm.data.adapter.shopAdapter
import com.bakclabagency.testandroidlm.data.model.ProductProvider
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.data.model.ShopProvider
import com.bakclabagency.testandroidlm.data.network.ShopService
import com.bakclabagency.testandroidlm.databinding.FragmentHomeBinding
import com.bakclabagency.testandroidlm.domain.ProductCseClient
import com.bakclabagency.testandroidlm.domain.ShopCaseClient
import com.bakclabagency.testandroidlm.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create


class HomeFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: productAdapter
    private val shopList = mutableListOf<ShopModel>()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root
        //binding.svProducts.setOnQueryTextListener(
        initRecylerView()
        homeViewModel.onStartHomeShop()

        homeViewModel.shopModel.observe(this, Observer<ShopModel>{
            binding.rvTiendas.layoutManager = LinearLayoutManager(context)
            binding.rvTiendas.adapter = shopAdapter(ShopProvider.shop)
        })
        return root
    }

    private fun initRecylerView(){


        binding.rvTiendas.layoutManager = LinearLayoutManager(context)
        binding.rvTiendas.adapter = shopAdapter(ShopProvider.shop)



    }
    /*Buscador*/
    private fun searchByName(query:String){
        val repository = ShopRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val call: List<ProductsModel> = repository.getAllProduct()

                if(!call.isNullOrEmpty()){

                }else{
                    //Show error
                }


        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        if(!p0.isNullOrEmpty()){
            searchByName(p0.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }
}


