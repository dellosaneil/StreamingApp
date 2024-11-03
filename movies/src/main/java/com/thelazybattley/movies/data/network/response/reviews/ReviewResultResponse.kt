package com.thelazybattley.movies.data.network.response.reviews

import com.thelazybattley.movies.domain.item.reviews.ReviewResult

data class ReviewResultResponse(
    val author: String,
    val authorDetails: ReviewAuthorDetailsResponse,
    val content: String,
    val createdAt: String,
    val id: String,
    val updatedAt: String,
    val url: String
)

fun ReviewResultResponse.toData() = ReviewResult(
    author = author,
    authorDetails = authorDetails.toData(),
    content = content,
    createdAt = createdAt,
    id = id,
)
