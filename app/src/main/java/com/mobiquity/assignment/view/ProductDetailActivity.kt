package com.mobiquity.assignment.view

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.ViewModelProviders
import com.mobiquity.assignment.BR
import com.mobiquity.assignment.R
import com.mobiquity.assignment.base.mvvm.BaseActivityMVVM
import com.mobiquity.assignment.databinding.ProductDetailBinding
import com.mobiquity.assignment.viewmodel.MenuListViewModel

/**
 * Created by Mehroze on 11/16/2019.
 */
class ProductDetailActivity: BaseActivityMVVM<ProductDetailBinding, MenuListViewModel>(){

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.product_detail
    }

    override fun getBindingViewModel(): MenuListViewModel {
        return ViewModelProviders.of(this).get(MenuListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.product_detail)
        val bundle = intent?.extras
        val product = bundle?.getParcelable<Parcelable>("product")
        getViewDataBinding().setVariable(BR.product,product)
        getViewDataBinding().setVariable(BR.context,this@ProductDetailActivity)

    }
}