package com.mobiquity.assignment.repository

import android.app.Application
import com.mindvalley.downloader.downloaderCore.networking.RetrofitProvider
import com.mobiquity.assignment.api.FoodAndDrinksAPI
import com.mobiquity.assignment.model.FoodAndDrinks
import io.reactivex.Single

class MenuListRepository(val application: Application, private val api: FoodAndDrinksAPI = RetrofitProvider.createAPI(
    FoodAndDrinksAPI::class.java)) {

    fun fetchEventsFromServer(): Single<List<FoodAndDrinks>>{
        return api.fetchFoodDrinkData()
    }

}