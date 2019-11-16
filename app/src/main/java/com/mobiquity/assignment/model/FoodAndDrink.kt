package com.mobiquity.assignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by Mehroze on 11/15/2019.
 */
data class FoodAndDrinks (

    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("products")
    @Expose
    var products: List<Product> = ArrayList()
)
