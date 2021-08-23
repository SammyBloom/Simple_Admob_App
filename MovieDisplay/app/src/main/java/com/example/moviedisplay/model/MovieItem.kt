package com.example.moviedisplay.model

import com.google.gson.annotations.SerializedName

data class Movie(
	val id: Int? = null,
	val page: Int? = null,
	val totalPages: Int? = null,
	val results: List<MovieItem?>? = null,
	val totalResults: Int? = null
)

data class MovieItem(
	val itemCount: Int? = null,
	val listType: String? = null,
	val name: String? = null,
	val description: String? = null,
	val favoriteCount: Int? = null,
	val id: Int? = null,
	val iso6391: String? = null,
	val posterPath: Any? = null
)

