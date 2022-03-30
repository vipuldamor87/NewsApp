package com.test.newsapp.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: String?) {

    if (!imageUrl.isNullOrBlank()) {

        Glide.with(view).load(imageUrl).into(view)

    }
}