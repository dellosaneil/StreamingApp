package com.thelazybattley.movies.data.item.movies

data class Movie(
    val genreIds: List<Int>,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val posterImage: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val backdropImage: String
)
