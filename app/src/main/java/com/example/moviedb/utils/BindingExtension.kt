package com.example.moviedb.utils
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingExtension{
    companion object{
        @JvmStatic
        @BindingAdapter("srcImage")
        fun setImage(view : AppCompatImageView, url : String){
            Glide.with(view.context)
                .asBitmap()
                .load(Constant.IMAGE_URL+url)
                .into(view)
        }
    }
}