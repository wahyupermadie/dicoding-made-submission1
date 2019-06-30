package com.example.moviedb.service.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviedb.service.model.popular.ResponsePopular
import com.example.moviedb.service.network.ApiService
import com.example.moviedb.utils.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieRepository(val apiService: ApiService?){

    @SuppressLint("CheckResult")
    fun getPopularMovie(): LiveData<ResponsePopular>{
        val popularMovies = MutableLiveData<ResponsePopular>()
        apiService?.getPopularMovies(Constant.API_KEY)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe({
                popularMovies.value = it
            },{
                popularMovies.value = null
            })
        return popularMovies
    }
}