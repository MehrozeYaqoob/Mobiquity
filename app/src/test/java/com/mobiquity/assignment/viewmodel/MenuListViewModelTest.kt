package com.mobiquity.assignment.viewmodel

import android.app.Application
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner


/**
 * Created by Mehroze on 11/16/2019.
 */
@RunWith(MockitoJUnitRunner::class)
class MenuListViewModelTest {

    lateinit var menuListViewModel: MenuListViewModel
    @Mock
    lateinit var application: Application

    @Before
    fun setUpRxSchedulers() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> Schedulers.trampoline() }
    }

    @Test
    fun fetchFoodDrinkData() {
        menuListViewModel = MenuListViewModel(application)
        menuListViewModel.fetchFoodDrinkData()
    }
}