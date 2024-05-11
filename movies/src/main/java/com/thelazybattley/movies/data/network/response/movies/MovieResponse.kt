package com.thelazybattley.movies.data.network.response.movies

import com.thelazybattley.movies.data.item.movies.Movie
import kotlin.math.round

data class MovieResponse(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

fun MovieResponse.toData() = Movie(
    genreIds = genreIds,
    id = id,
    overview = overview,
    popularity = popularity,
    posterImage = posterPath,
    releaseDate = releaseDate,
    title = title,
    voteAverage = round(voteAverage * 10) / 10,
    backdropImage = backdropPath ?: ""
)
