package com.demoapparchitecurecomponent

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun ImageView.loadImageFromUrl(url : String){
        Glide.with(this.context).load(url).into(this)
 }