package com.mobiquity.assignment.networking

import com.mobiquity.assignment.api.FoodAndDrinksAPI
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

/**
 * Created by Mehroze on 11/17/2019.
 */
class RetrofitProviderTest : ApiAbstract<FoodAndDrinksAPI>() {


    private var service: FoodAndDrinksAPI? = null

    @Before
    fun initService() {
        this.service = createService(FoodAndDrinksAPI::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun fetchMovieDetailsTest() {
        enqueueResponse("food_drink.json")
        val foodDrinkData = service!!.fetchFoodDrinkData().blockingGet()
        Assert.assertEquals("36802", foodDrinkData[0].id)
        Assert.assertEquals("/Cola.jpg", foodDrinkData[1].products[0].url)
    }

}