package com.example.moviedisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedisplay.adapter.MovieAdapter
import com.example.moviedisplay.model.Movie
import com.example.moviedisplay.model.MovieItem
import com.example.moviedisplay.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MovieAdapter
    private lateinit var progressBar: ProgressBar

    private var arrList = ArrayList<MovieItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Intent that started this activity and extract the string
        val movie_id = intent.getIntExtra("MOVIE_Id", 0)

        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE
        setUpRecyclerView()

        val repository = Repository()
        val viewModelFactory = MovieViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)

        val key = getString(R.string.api_key)
        Log.d("apiKey", key)

        viewModel.getMovie(movie_id, key)
        viewModel.myResponse.observe(
            this,
            Observer { response ->
                if (response.isSuccessful) {
                    val usersResponse = response.body()
                    Log.d("response", usersResponse.toString())
                    usersResponse?.let { arrList.addAll(it) }
                    progressBar.visibility = View.INVISIBLE
                    mAdapter.notifyDataSetChanged()
                } else {
                    Log.d("errorMessage", response)
                    Toast.makeText(applicationContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.INVISIBLE
                }
            }
        )
    }

    private fun setUpRecyclerView(){
        recyclerView = findViewById(R.id.user_recyclerview)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            mAdapter = MovieAdapter(this@MainActivity, arrList)
            recyclerView.adapter = mAdapter
        }
    }

}