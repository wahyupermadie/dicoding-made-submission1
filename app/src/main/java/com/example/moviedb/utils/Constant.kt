package com.example.moviedb.utils

import java.text.SimpleDateFormat
import java.util.*

object Constant{
    val API_KEY = "01c5d0d1ff15325934327ab3965e26f6"
    val IMAGE_URL = "https://image.tmdb.org/t/p/w342"

    fun dateFormat(value : String) : String{

        val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.US);
        val date = sdf.parse(value)

        val newSdf = SimpleDateFormat("dd-MMM-yyyy", Locale.US)
        return newSdf.format(date!!)
    }
}