package com.mobiquity.assignment.contracts

import com.mobiquity.assignment.model.FoodAndDrinks
import io.reactivex.Single

/**
 * Created by Mehroze on 11/18/2019.
 */
interface IRepository  {

    fun fetchFoodDrinkData(): Single<List<FoodAndDrinks>>
}