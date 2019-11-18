package com.mobiquity.assignment.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.mobiquity.assignment.databinding.ItemProductBinding
import com.mobiquity.assignment.model.Product
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.*
import org.mockito.Mock
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


/**
 * Created by Mehroze on 11/16/2019.
 */
@RunWith(PowerMockRunner::class)
@PrepareForTest( DataBindingUtil::class, ViewDataBinding::class, LayoutInflater::class)
class ProductItemViewHolderTest {

    @Mock
    private lateinit var itemProductBinding: ItemProductBinding
    private lateinit var product: Product
    lateinit var productItemViewHolder: ProductItemViewHolder
    @Mock
    lateinit var context: Context
    @Mock
    lateinit var inflater: LayoutInflater

    @Before
    fun setUp() {
        context = Mockito.mock(Context::class.java)
        inflater = Mockito.mock(LayoutInflater::class.java)

        PowerMockito.mockStatic(DataBindingUtil::class.java)
        PowerMockito.mockStatic(ViewDataBinding::class.java)
        PowerMockito.mockStatic(LayoutInflater::class.java)
        PowerMockito.`when`<LayoutInflater>(LayoutInflater::class.java, "from", context).thenReturn(inflater)
        PowerMockito.`when`<ItemProductBinding>(DataBindingUtil::class.java, "inflate", eq(inflater), anyInt(), any(ViewGroup::class.java), anyBoolean()).
            thenReturn(itemProductBinding)

    }

    @Test
    fun bind() {
        product = Product()
        productItemViewHolder = ProductItemViewHolder(Mockito.mock(View::class.java))
        productItemViewHolder.bind(product)
    }


}