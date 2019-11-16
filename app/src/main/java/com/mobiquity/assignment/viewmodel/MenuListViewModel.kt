package com.mobiquity.assignment.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import com.mobiquity.assignment.repository.MenuListRepository
import com.mobiquity.assignment.base.mvvm.BaseViewModel
import com.mobiquity.assignment.model.FoodAndDrinks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MenuListViewModel(application: Application) : BaseViewModel(application) {
    val menuListLiveData: MutableLiveData<List<FoodAndDrinks>> = MutableLiveData()
    private val menuListRepository: MenuListRepository = MenuListRepository(application)

    @SuppressLint("CheckResult")
    fun fetchUserInformation(){
        menuListRepository.fetchEventsFromServer().observeOn(AndroidSchedulers.mainThread()).
            subscribeOn(Schedulers.io()).subscribe(Consumer {
            menuListLiveData.postValue(it)
        })
    }

    fun handleIntentArguements(intent: Intent?) {
        val bundle = intent?.extras
        val product = bundle?.getParcelable<Parcelable>("product")

    }
}
