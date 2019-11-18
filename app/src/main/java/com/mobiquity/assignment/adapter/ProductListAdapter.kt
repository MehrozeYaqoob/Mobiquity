package com.mobiquity.assignment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.R
import com.mobiquity.assignment.contracts.OnItemClicked
import com.mobiquity.assignment.databinding.ItemProductBinding
import com.mobiquity.assignment.model.Product
import com.mobiquity.assignment.viewholder.ProductItemViewHolder


class ProductListAdapter(private val productList: MutableList<Product>, val listener: OnItemClicked) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var viewHolder: ProductItemViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val productItemBinding = DataBindingUtil.inflate<ItemProductBinding>(LayoutInflater.from(parent.context), R.layout.item_product, parent, false)
        viewHolder = ProductItemViewHolder(productItemBinding, listener)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder) {
            is ProductItemViewHolder -> {
                Log.d("======>>>>>>> name ",""+ productList[position].name)
                viewHolder.bind(productList[position])}
        }
    }

    fun updateList(list: MutableList<Product>) {
        productList.size.let { if (it > 0){productList.clear()} }
        productList.addAll(list)
    }
}

