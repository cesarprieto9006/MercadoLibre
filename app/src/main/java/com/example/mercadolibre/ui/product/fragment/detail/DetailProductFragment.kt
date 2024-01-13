package com.example.mercadolibre.ui.product.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mercadolibre.R
import com.example.mercadolibre.databinding.FragmentDetailProductBinding
import com.example.mercadolibre.ui.product.fragment.detail.adapter.ImageSlideAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat

@AndroidEntryPoint
class DetailProductFragment : Fragment() {

    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DetailProductViewModel>()

    private lateinit var viewPagerAdapter: ImageSlideAdapter

    private val format = DecimalFormat("#,###")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)

        configureBinding()
        configureImage()
        configureProductDetail()
        configureOnclick()

        viewModel.getProductDetails(arguments?.getString("productId").toString())

        return binding.root
    }

    private fun configureOnclick(){
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun configureProductDetail() {
        viewModel.product.observe(viewLifecycleOwner) { productDetail ->
            val builder = StringBuilder()
            if (productDetail != null) {
                binding.tvTitleProduct.text = productDetail.title
                binding.tvDescriptionProduct.text = productDetail.description
                binding.tvPriceProduct.text =
                    builder.append("$ ").append(format.format(productDetail.price))
                binding.tvLocationProduct.text = productDetail.location
                viewPagerAdapter = ImageSlideAdapter(requireContext(), productDetail.picturesUrl)
                binding.viewpager.adapter = viewPagerAdapter
                binding.cIndicator.setViewPager(binding.viewpager)
            }
        }
    }

    private fun configureImage() {
        viewModel.selectImage.observe(viewLifecycleOwner) { movements ->
            if (movements != null) {
                binding.imgError.setBackgroundResource(R.drawable.error_connection)
            }
        }
    }

    private fun configureBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

}
