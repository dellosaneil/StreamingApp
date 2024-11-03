package com.thelazybattley.movies.data.network.response.recommendations

import com.thelazybattley.movies.domain.item.recommendations.RecommendationsResult
import kotlin.math.round

data class RecommendationsResultResponse(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val mediaType: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

fun RecommendationsResultResponse.toData() = RecommendationsResult(
    title = title,
    voteAverage = round(voteAverage * 10) / 10,
    id = id,
    posterImage =  posterPath ?: ""
)
