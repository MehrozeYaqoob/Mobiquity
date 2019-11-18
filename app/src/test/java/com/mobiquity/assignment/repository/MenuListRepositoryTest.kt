package com.mobiquity.assignment.repository

import com.mobiquity.assignment.api.FoodAndDrinksAPI
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Mehroze on 11/16/2019.
 */
@RunWith(MockitoJUnitRunner::class)
class MenuListRepositoryTest {

    @Mock
    lateinit var api: FoodAndDrinksAPI
    lateinit var repository: MenuListRepository

    @Test
    fun fetchFoodDrinkData() {
        repository = MenuListRepository( api)
        Mockito.`when`(repository.fetchFoodDrinkData()).thenReturn(Single.just(listOf()))
        repository.fetchFoodDrinkData().test().assertValue(listOf())
    }
}