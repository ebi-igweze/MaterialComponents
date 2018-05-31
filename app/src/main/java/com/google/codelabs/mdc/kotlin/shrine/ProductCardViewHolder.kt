package com.google.codelabs.mdc.kotlin.shrine

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView
import com.google.codelabs.mdc.kotlin.shrine.network.ImageRequester
import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry

class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val productImage: NetworkImageView = itemView.findViewById(R.id.product_image)
    private val productTitle: TextView = itemView.findViewById(R.id.product_title)
    private val productPrice: TextView = itemView.findViewById(R.id.product_price)

    fun bindView(product: ProductEntry) {
        productTitle.text = product.title
        productPrice.text = product.price
        ImageRequester.setImageFromUrl(productImage, product.url)
    }
}
