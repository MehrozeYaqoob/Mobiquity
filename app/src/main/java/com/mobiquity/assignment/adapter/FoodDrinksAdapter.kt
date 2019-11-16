package com.mobiquity.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.R
import com.mobiquity.assignment.model.FoodAndDrinks
import com.mobiquity.assignment.viewholder.ProductListingViewHolder
import kotlinx.android.synthetic.main.product_listing.view.*

class FoodDrinksAdapter(private val foodDrinksList: MutableList<FoodAndDrinks>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var productListingViewHolder : ProductListingViewHolder
    private var productListAdapter : ProductListAdapter = ProductListAdapter(ArrayList())


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val productListBinding = LayoutInflater.from(parent.context).inflate(R.layout.product_listing, parent, false)
        productListingViewHolder = ProductListingViewHolder(productListBinding, productListAdapter)
        return productListingViewHolder
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        productListingViewHolder.view.txt_product_category.text = foodDrinksList[position].name ?: "Item"
        productListAdapter.updateList(foodDrinksList[position].products.toMutableList())
        productListingViewHolder.bind()
    }

    override fun getItemCount(): Int {
        return foodDrinksList.size
    }

    fun updateMenuCategoryList(list: MutableList<FoodAndDrinks>){
        foodDrinksList.clear()
        foodDrinksList.addAll(list)
        notifyDataSetChanged()
    }
}

