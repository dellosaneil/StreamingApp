package com.thelazybattley.movies.domain.item.reviews

data class ReviewResult(
    val author: String,
    val authorDetails: ReviewAuthorDetails,
    val content: String,
    val createdAt: String,
    val id: String,
)
