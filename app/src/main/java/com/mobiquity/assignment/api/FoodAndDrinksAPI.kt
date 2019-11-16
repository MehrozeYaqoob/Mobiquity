package com.mobiquity.assignment.api

import com.mobiquity.assignment.model.FoodAndDrinks
import io.reactivex.Single
import retrofit2.http.GET

interface FoodAndDrinksAPI {
    @GET( "/")
    fun fetchFoodDrinkData( ): Single<List<FoodAndDrinks>>
}