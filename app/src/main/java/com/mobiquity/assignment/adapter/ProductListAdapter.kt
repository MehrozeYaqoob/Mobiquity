package com.mobiquity.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.R
import com.mobiquity.assignment.databinding.ItemProductBinding
import com.mobiquity.assignment.model.Product
import com.mobiquity.assignment.viewholder.ProductItemViewHolder


class ProductListAdapter(private val productList: MutableList<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var viewHolder: ProductItemViewHolder? = null
    private lateinit var recyclerView: RecyclerView


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val productItemBinding = DataBindingUtil.inflate<ItemProductBinding>(LayoutInflater.from(parent.context), R.layout.item_product, parent, false)
        viewHolder = ProductItemViewHolder(productItemBinding)
        return viewHolder!!
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder) {
            is ProductItemViewHolder -> viewHolder.bind(productList[position])
        }
    }

    fun updateList(list: MutableList<Product>) {
        productList.clear()
        productList.addAll(list)
    }
}

