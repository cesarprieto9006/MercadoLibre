package com.example.mercadolibre.ui.product.fragment.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.data.dto.ProductData
import com.example.mercadolibre.databinding.ItemProductBinding
import java.text.DecimalFormat

class ProductAdapter(
    private val products: List<ProductData>,
    private val onItemClick: ((data: ProductData) -> Unit)? = null,
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val item = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(item)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val movement = products[position]
        holder.bind(movement)
    }

    override fun getItemCount() = products.size

    inner class ProductViewHolder(private val item: ItemProductBinding) :
        RecyclerView.ViewHolder(item.root) {

        private val format = DecimalFormat("#,###.00")
        fun bind(product: ProductData) {

            val valueFormat: String = format.format(product.price)

            item.lblPriceProduct.text = valueFormat
            item.lblTitleProduct.text = product.title
            item.lblShippingProduct.text = product.condition
            item.imgItemProduct.load(product.pictureUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            item.lyItemProduct.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }
}
