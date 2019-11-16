package com.mobiquity.assignment.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mehroze on 11/15/2019.
 */
@Parcelize
data class SalePrice(

    @SerializedName("amount")
    @Expose
    var amount: String = "",
    @SerializedName("currency")
    @Expose
    var currency: String = "") : Parcelable