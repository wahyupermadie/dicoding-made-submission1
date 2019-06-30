package com.example.moviedb.service.network

import com.example.moviedb.service.model.popular.ResponsePopular
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") key : String) : Flowable<ResponsePopular>

}