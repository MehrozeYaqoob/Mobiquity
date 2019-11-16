package com.mobiquity.assignment.model

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Parcelable
import androidx.appcompat.content.res.AppCompatResources
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mobiquity.assignment.BuildConfig.BASE_URL
import com.mobiquity.assignment.R
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mehroze on 11/15/2019.
 */
@Parcelize
data class Product(

    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("categoryId")
    @Expose
    var categoryId: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("salePrice")
    @Expose
    var salePrice: SalePrice? = null
) : Parcelable {

    fun getImageUrl(): String {
        return BASE_URL + url
    }

    fun getPrice(): String {
        return salePrice?.amount + " " + salePrice?.currency
    }

    fun getPlaceHolder(context: Context): Drawable {
        return AppCompatResources.getDrawable(
            context.applicationContext,
            R.drawable.product_placeholder
        )!!
    }

}

