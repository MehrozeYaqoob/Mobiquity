package com.mobiquity.assignment.repository

import com.mobiquity.assignment.api.FoodAndDrinksAPI
import com.mobiquity.assignment.contracts.IRepository
import com.mobiquity.assignment.model.FoodAndDrinks
import com.mobiquity.assignment.networking.RetrofitProvider
import io.reactivex.Single

class MenuListRepository(private val api: FoodAndDrinksAPI = RetrofitProvider.createAPI(
    FoodAndDrinksAPI::class.java)) : IRepository{

    override fun fetchFoodDrinkData(): Single<List<FoodAndDrinks>>{
        return api.fetchFoodDrinkData()
    }

}