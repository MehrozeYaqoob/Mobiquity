package com.mobiquity.assignment.viewholder

import android.view.View
import com.mobiquity.assignment.adapter.ProductListAdapter
import com.mobiquity.assignment.contracts.OnItemClicked
import org.junit.Test
import org.mockito.Matchers.any
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Created by Mehroze on 11/17/2019.
 */
class ProductListingViewHolderTest {

    lateinit var productListingViewHolder: ProductListingViewHolder
    lateinit var productListAdapter: ProductListAdapter
    @Mock
    lateinit var itemClicked : OnItemClicked

    @Test
    fun bind() {
        itemClicked = Mockito.mock(OnItemClicked::class.java)
        productListAdapter = ProductListAdapter(mutableListOf(), itemClicked)
        productListingViewHolder = ProductListingViewHolder(Mockito.mock(View::class.java),productListAdapter)
        productListingViewHolder.bind()
    }
}