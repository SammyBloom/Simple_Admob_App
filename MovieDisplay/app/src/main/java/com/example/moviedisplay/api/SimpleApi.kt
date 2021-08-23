package com.example.moviedisplay.api

import com.example.moviedisplay.model.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("/3/movie/{movie_id}/lists")
    suspend fun getMovie(
        @Path ("movie_id") number: Int,
        @Query ("api_key") key: String
    ): Response<Movies>

}