package com.mobiquity.assignment.viewholder

import android.view.View
import com.mobiquity.assignment.adapter.ProductListAdapter
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Mehroze on 11/17/2019.
 */
class ProductListingViewHolderTest {

    lateinit var productListingViewHolder: ProductListingViewHolder
    lateinit var productListAdapter: ProductListAdapter

    @Test
    fun bind() {
        productListAdapter = ProductListAdapter(mutableListOf())
        productListingViewHolder = ProductListingViewHolder(Mockito.mock(View::class.java),productListAdapter)
        productListingViewHolder.bind()
    }
}