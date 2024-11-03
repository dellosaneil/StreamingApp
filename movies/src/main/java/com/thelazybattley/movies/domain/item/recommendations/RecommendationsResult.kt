package com.thelazybattley.movies.domain.item.recommendations

data class RecommendationsResult(
    val id: Int,
    val posterImage: String,
    val title: String,
    val voteAverage: Double,
)
