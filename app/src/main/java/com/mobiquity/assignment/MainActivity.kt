package com.mobiquity.assignment

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mobiquity.assignment.adapter.FoodDrinksAdapter
import com.mobiquity.assignment.base.mvvm.BaseActivityMVVM
import com.mobiquity.assignment.databinding.ActivityMainBinding
import com.mobiquity.assignment.model.FoodAndDrinks
import com.mobiquity.assignment.viewmodel.MenuListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivityMVVM<ActivityMainBinding, MenuListViewModel>(),
    SwipeRefreshLayout.OnRefreshListener {

    private lateinit var adapter: FoodDrinksAdapter
    var foodDrinksList = ArrayList<FoodAndDrinks>()


    override fun onRefresh() {
        getViewModel().fetchUserInformation()
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingViewModel(): MenuListViewModel {
        return ViewModelProviders.of(this).get(MenuListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        observeMenuList()

        pullToRefresh.setOnRefreshListener(this)
        pullToRefresh.isRefreshing = true
        getViewModel().fetchUserInformation()
    }


    private fun initRecyclerView(){
        adapter = FoodDrinksAdapter(foodDrinksList)
        recyclerview.adapter = adapter
    }

    private fun observeMenuList() {
        getViewModel().menuListLiveData.observe(this, Observer {
            adapter.updateMenuCategoryList(it.toMutableList())
            pullToRefresh.isRefreshing = false
        })
    }
}
