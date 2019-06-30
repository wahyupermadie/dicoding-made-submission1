package com.example.moviedb.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.moviedb.databinding.MovieItemsBinding
import com.example.moviedb.service.model.popular.ResultsItem

class PopularAdapter : BaseAdapter(){
    var popularList : List<ResultsItem>? = emptyList()

    fun addMovies(popular : List<ResultsItem>){
        popularList = popular
//        Log.d("POPULAR_LIST"," LIST "+popularList)
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding: MovieItemsBinding = MovieItemsBinding.inflate(LayoutInflater.from(p2?.context), p2, false)
        binding.root.tag = binding

        binding.populars = getItem(p0) as ResultsItem
        return binding.root
    }

    override fun getItem(p0: Int): Any? {
        Log.d("POPULAR_LIST"," ITEM "+popularList?.get(p0))
        return popularList?.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        Log.d("POPULAR_LIST"," ITEM "+popularList?.size)
        return if(popularList?.size == null) 0  else popularList!!.size
    }

}