package com.mobiquity.assignment.viewholder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.BR
import com.mobiquity.assignment.databinding.ItemProductBinding
import com.mobiquity.assignment.model.Product
import com.mobiquity.assignment.view.ProductDetailActivity

class ProductItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var itemProductBinding: ItemProductBinding
    private lateinit var product: Product

    constructor(itemProductBinding: ItemProductBinding) : this(itemProductBinding.root) {
        this.itemProductBinding = itemProductBinding
    }

    fun bind(item: Product) {
        product = item
        itemProductBinding.context = itemView.context
        itemProductBinding.setVariable(BR.product, item)
        itemView.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val intent = Intent(itemView.context, ProductDetailActivity::class.java)
        intent.putExtra("product",product)
        itemView.context.startActivity(intent)
    }

}
