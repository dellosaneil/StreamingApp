package com.thelazybattley.movies.data.network.response.reviews

import com.thelazybattley.movies.domain.item.reviews.ReviewData

data class ReviewDataResponse(
    val id: Int,
    val page: Int,
    val results: List<ReviewResultResponse>,
    val totalPages: Int,
    val totalResults: Int
)

fun ReviewDataResponse.toData() = ReviewData(
    id = id,
    results = results.map {
        it.toData()
    },
    totalResults = totalResults
)
