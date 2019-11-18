package com.mobiquity.assignment.viewholder

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.R
import com.mobiquity.assignment.adapter.ProductListAdapter


class ProductListingViewHolder(val view: View, private val productListAdapter: ProductListAdapter) : RecyclerView.ViewHolder(view){

    var recyclerView: RecyclerView? = null

    init {
        val manager = GridLayoutManager(itemView.context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView = view.findViewById(R.id.recycle_view_product_listing)
        recyclerView?.layoutManager = manager;
    }

    fun bind() {
        recyclerView?.adapter = productListAdapter

    }
}
