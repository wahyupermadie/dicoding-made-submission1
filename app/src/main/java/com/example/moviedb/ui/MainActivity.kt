package com.example.moviedb.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.moviedb.R
import com.example.moviedb.adapter.PopularAdapter
import com.example.moviedb.service.model.popular.ResultsItem
import com.example.moviedb.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModel()
    private lateinit var popularAdapter : PopularAdapter
    private var popularList : List<ResultsItem>? = null
    private lateinit var dialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        fetchData()
    }

    private fun fetchData() {
        mainViewModel.getPopularMovies().observe(this, Observer {
            popularList = it.results
            dialog.dismiss()
            setAdapter()
        })
    }

    private fun setAdapter() {
        popularList?.let { popularAdapter.addMovies(it) }
        lv_movie.adapter = popularAdapter
        popularAdapter.notifyDataSetChanged()
        lv_movie.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                startActivity<DetailActivity>("details" to popularList?.get(p2))
            }
        })
    }

    private fun init() {
        dialog = indeterminateProgressDialog("Fetching data...","Loading...")
        dialog.setCancelable(false)
        dialog.show()
        popularAdapter = PopularAdapter()
    }
}
