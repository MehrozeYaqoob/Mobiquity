package com.mobiquity.assignment.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.R
import com.mobiquity.assignment.adapter.ProductListAdapter


class ProductListingViewHolder(val view: View, private val productListAdapter: ProductListAdapter) : RecyclerView.ViewHolder(view){

    var recyclerView: RecyclerView? = null

    init {
        recyclerView = view.findViewById(R.id.recycle_view_product_listing)
    }

    fun bind() {
        recyclerView?.adapter = productListAdapter
    }
}
