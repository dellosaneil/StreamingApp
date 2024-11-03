package com.thelazybattley.movies.domain.item.reviews

data class ReviewData(
    val id: Int,
    val results: List<ReviewResult>,
    val totalResults: Int
)
