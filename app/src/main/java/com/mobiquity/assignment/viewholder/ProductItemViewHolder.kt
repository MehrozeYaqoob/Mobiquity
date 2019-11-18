package com.mobiquity.assignment.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.BR
import com.mobiquity.assignment.contracts.OnItemClicked
import com.mobiquity.assignment.databinding.ItemProductBinding
import com.mobiquity.assignment.model.Product

class ProductItemViewHolder(private val view: View, val listener: OnItemClicked) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var itemProductBinding: ItemProductBinding
    private lateinit var product: Product

    constructor(itemProductBinding: ItemProductBinding, listener: OnItemClicked) : this(itemProductBinding.root, listener) {
        this.itemProductBinding = itemProductBinding
    }

    fun bind(item: Product) {
        product = item
        itemProductBinding.context = itemView.context
        itemProductBinding.setVariable(BR.product, item)
        itemView.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        listener.itemClicked(product)
    }

}
