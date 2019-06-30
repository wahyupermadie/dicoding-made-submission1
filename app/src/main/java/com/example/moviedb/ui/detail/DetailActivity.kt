package com.example.moviedb.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.service.model.popular.ResultsItem
import com.example.moviedb.utils.Constant
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var moviesItem : ResultsItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        moviesItem = intent.getParcelableExtra("details")
        setItem()
    }

    private fun setItem() {

        supportActionBar?.title = moviesItem?.title
        Glide.with(this).asBitmap()
            .load(Constant.IMAGE_URL+moviesItem?.backdropPath)
            .into(iv_backdrop_detail)

        Glide.with(this).asBitmap()
            .load(Constant.IMAGE_URL+moviesItem?.posterPath)
            .into(iv_poster_movie_detail)

        tv_language_value.text = moviesItem?.originalLanguage
        tv_title_detail.text = moviesItem?.title
        tv_release_value.text = Constant.dateFormat(moviesItem?.releaseDate.toString())
        tv_vote_value.text = moviesItem?.voteAverage.toString()
        tv_overview_value.text = moviesItem?.overview
    }
}
