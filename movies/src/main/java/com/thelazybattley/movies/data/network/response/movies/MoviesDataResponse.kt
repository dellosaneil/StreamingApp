package com.thelazybattley.movies.data.network.response.movies

data class MoviesDataResponse(
    val page: Int,
    val results: List<MovieResponse>,
    val totalPages: Int,
    val totalResults: Int
)
