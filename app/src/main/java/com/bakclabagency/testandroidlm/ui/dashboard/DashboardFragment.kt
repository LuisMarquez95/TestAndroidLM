package com.bakclabagency.testandroidlm.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bakclabagency.testandroidlm.R
import com.bakclabagency.testandroidlm.data.adapter.productAdapter
import com.bakclabagency.testandroidlm.data.adapter.shopAdapter
import com.bakclabagency.testandroidlm.data.model.ProductProvider
import com.bakclabagency.testandroidlm.data.model.ProductsModel
import com.bakclabagency.testandroidlm.data.model.ShopModel
import com.bakclabagency.testandroidlm.data.model.ShopProvider
import com.bakclabagency.testandroidlm.databinding.FragmentDashboardBinding
import com.bakclabagency.testandroidlm.domain.ShopCaseClient
import com.bakclabagency.testandroidlm.ui.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val recyclerView: RecyclerView = binding.rvShop
        dashboardViewModel.onStartDash()
        initRecylerView()



       // val textView: TextView = binding.textDashboard



        return root
    }

    private fun initRecylerView(){
        binding.rvShop.layoutManager = LinearLayoutManager(context)
        binding.rvShop.adapter = productAdapter(ProductProvider.product)
        dashboardViewModel.onStartDash()
        //recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = shopAdapter(ShopCaseClient())*/

        dashboardViewModel.productModel.observe(this, Observer<ProductsModel> {

            //recyclerView.adapter = shopAdapter(ShopProvider.shop)
            binding.rvShop.layoutManager = LinearLayoutManager(context)
            binding.rvShop.adapter = productAdapter(ProductProvider.product)
        })

    }

    override fun onStart() {

        val recyclerView: RecyclerView = binding.rvShop
        recyclerView.layoutManager = LinearLayoutManager(context)
        dashboardViewModel.onStartDash()

        dashboardViewModel.productModel.observe(this, Observer<ProductsModel> {


            binding.rvShop.layoutManager = LinearLayoutManager(context)
            binding.rvShop.adapter = productAdapter(ProductProvider.product)
        })
        super.onStart()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}