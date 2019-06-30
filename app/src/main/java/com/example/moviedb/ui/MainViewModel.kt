package com.example.moviedb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.service.model.popular.ResponsePopular
import com.example.moviedb.service.network.ApiService
import com.example.moviedb.service.repository.MovieRepository

class MainViewModel(apiService: ApiService?) : ViewModel(){
    val repository = MovieRepository(apiService)
    fun getPopularMovies() : LiveData<ResponsePopular>{
        return repository.getPopularMovie()
    }
}