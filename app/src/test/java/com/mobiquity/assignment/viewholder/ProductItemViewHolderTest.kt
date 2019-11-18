package com.mobiquity.assignment.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.mobiquity.assignment.contracts.OnItemClicked
import com.mobiquity.assignment.databinding.ItemProductBinding
import com.mobiquity.assignment.model.Product
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


/**
 * Created by Mehroze on 11/16/2019.
 */
@RunWith(MockitoJUnitRunner::class)
class ProductItemViewHolderTest {

    private lateinit var product: Product
    lateinit var productItemViewHolder: ProductItemViewHolder

    @Mock
    lateinit var itemClicked: OnItemClicked

    @Before
    fun setUp() {
        itemClicked = Mockito.mock(OnItemClicked::class.java)

    }

    @Test
    fun bind() {
        product = Product()
        productItemViewHolder = ProductItemViewHolder(Mockito.mock(View::class.java), itemClicked)
        productItemViewHolder.bind(product)
    }

}