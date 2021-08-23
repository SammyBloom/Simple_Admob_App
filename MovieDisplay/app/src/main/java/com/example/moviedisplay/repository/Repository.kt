package com.example.moviedisplay.repository

import com.example.moviedisplay.api.RetrofitInstance
import com.example.moviedisplay.model.Movies
import retrofit2.Response

class Repository {
    suspend fun getMovie(number: Int, key: String): Response<Movies> {
        return RetrofitInstance.api.getMovie(number, key)
    }
}