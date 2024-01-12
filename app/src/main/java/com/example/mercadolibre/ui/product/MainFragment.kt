package com.example.mercadolibre.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.data.dto.ProductData
import com.example.mercadolibre.R
import com.example.mercadolibre.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: MovementsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        configureBinding()
        configureSearch()
        configureListProduct()
        configureImage()

        return binding.root
    }

    private fun configureBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvProduct.isNestedScrollingEnabled = true
    }

    private fun configureImage() {
        viewModel.selectImage.observe(viewLifecycleOwner) { movements ->
            if (movements != null) {
                when (movements) {
                    TypeImage.SEARCH -> binding.imgError.setBackgroundResource(R.drawable.search)
                    TypeImage.ERROR -> binding.imgError.setBackgroundResource(R.drawable.error_connection)
                    TypeImage.NOT_FOUND -> binding.imgError.setBackgroundResource(R.drawable.not_product)
                }
            }
        }
    }

    private fun configureListProduct() {
        viewModel.product.observe(viewLifecycleOwner) { movements ->
            if (movements != null) {
                adapter = MovementsAdapter(movements, ::onItemClickAdd)
                binding.adapter = adapter
            }
        }
    }

    private fun onItemClickAdd(movement: ProductData) {
        Toast.makeText(requireActivity(), movement.id, Toast.LENGTH_SHORT).show()
    }

    private fun configureSearch() {
        binding.etSearchProduct.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(s: String): Boolean {
                return true
            }
            override fun onQueryTextSubmit(text: String): Boolean {
                viewModel.searchProduct(text)
                return false
            }
        })
    }
}
