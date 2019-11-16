package com.mobiquity.assignment.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(context.applicationContext).load(url).into(this)
}

@BindingAdapter(value= ["imageUrl", "placeHolderImage"], requireAll = true)
fun ImageView.setImageUrl(imageUrl: String?,placeHolderImage: Drawable? ) {
    Glide.with(context.applicationContext).load(imageUrl).placeholder(placeHolderImage).into(this)
}
