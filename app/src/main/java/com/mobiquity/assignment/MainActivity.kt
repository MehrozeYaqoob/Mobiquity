package com.mobiquity.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mobiquity.assignment.adapter.FoodDrinksAdapter
import com.mobiquity.assignment.base.mvvm.BaseActivityMVVM
import com.mobiquity.assignment.contracts.OnItemClicked
import com.mobiquity.assignment.databinding.ActivityMainBinding
import com.mobiquity.assignment.model.FoodAndDrinks
import com.mobiquity.assignment.model.Product
import com.mobiquity.assignment.util.SettingsUtility
import com.mobiquity.assignment.view.ProductDetailActivity
import com.mobiquity.assignment.viewmodel.MenuListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivityMVVM<ActivityMainBinding, MenuListViewModel>(), OnItemClicked ,SwipeRefreshLayout.OnRefreshListener {

    private lateinit var adapter: FoodDrinksAdapter
    var foodDrinksList = ArrayList<FoodAndDrinks>()


    override fun onRefresh() {
        getViewModel().fetchFoodDrinkData()
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

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        initRecyclerView()
        observeMenuList()

        pullToRefresh.setOnRefreshListener(this)
        pullToRefresh.isRefreshing = true

        // Invoke API which will fetch data and notify via LiveData
        SettingsUtility.isNetworkAvailable(this).let { if(it){
            getViewModel().fetchFoodDrinkData()
        }else{
            Toast.makeText(this,getString(R.string.no_internet),Toast.LENGTH_SHORT).show()
        } }
    }

    /**
     * This will initialize Recycler View adapter after create adapter object
     */
    fun initRecyclerView(){
        adapter = FoodDrinksAdapter(foodDrinksList, this)
        recyclerview.adapter = adapter
    }

    /**
     * This will observe Live Data and update Adapter List
     */
    fun observeMenuList() {
        getViewModel().menuListLiveData.observe(this, Observer {
            adapter.updateMenuCategoryList(it.toMutableList())
            pullToRefresh.isRefreshing = false
        })
    }

    override fun itemClicked(product : Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)
    }

}
