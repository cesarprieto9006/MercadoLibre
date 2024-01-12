package com.example.mercadolibre.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.data.dto.ProductData
import com.example.mercadolibre.databinding.ItemProductBinding
import java.text.DecimalFormat

class MovementsAdapter(
    private val movements: List<ProductData>,
    private val onItemClick: ((data: ProductData) -> Unit)? = null,
) : RecyclerView.Adapter<MovementsAdapter.MovementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementViewHolder {
        val item = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovementViewHolder(item)
    }

    override fun onBindViewHolder(holder: MovementViewHolder, position: Int) {
        val movement = movements[position]
        holder.bind(movement)
    }

    override fun getItemCount() = movements.size

    inner class MovementViewHolder(private val item: ItemProductBinding) :
        RecyclerView.ViewHolder(item.root) {

        private val format = DecimalFormat("#,###.00")
        fun bind(movement: ProductData) {

            val valueFormat: String = format.format(movement.price)

            item.lblPriceProduct.text = valueFormat
            item.lblTitleProduct.text = movement.title
            item.lblShippingProduct.text = movement.condition
            item.imgItemProduct.load(movement.pictureUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            item.lyItemProduct.setOnClickListener {
                onItemClick?.invoke(movement)
            }
        }
    }
}
