package com.mobiquity.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.assignment.R
import com.mobiquity.assignment.contracts.OnItemClicked
import com.mobiquity.assignment.model.FoodAndDrinks
import com.mobiquity.assignment.viewholder.ProductListingViewHolder
import kotlinx.android.synthetic.main.product_listing.view.*

class FoodDrinksAdapter(private val foodDrinksList: MutableList<FoodAndDrinks>,val listener: OnItemClicked) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var productListingViewHolder : ProductListingViewHolder
    private var productListAdapter : ProductListAdapter = ProductListAdapter(ArrayList(), listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val productListBinding = LayoutInflater.from(parent.context).inflate(R.layout.product_listing, parent, false)
        productListAdapter.updateList(foodDrinksList[viewType].products.toMutableList())
        productListingViewHolder = ProductListingViewHolder(productListBinding, productListAdapter)
        productListingViewHolder.bind()
        return productListingViewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        productListingViewHolder.view.txt_product_category.text = foodDrinksList[position].name ?: "Item"
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

