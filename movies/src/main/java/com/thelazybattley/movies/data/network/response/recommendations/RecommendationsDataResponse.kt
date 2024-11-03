package com.thelazybattley.movies.data.network.response.recommendations

import com.thelazybattley.movies.domain.item.recommendations.RecommendationsData

data class RecommendationsDataResponse(
    val page: Int,
    val results: List<RecommendationsResultResponse>,
    val totalPages: Int,
    val totalResults: Int
)

fun RecommendationsDataResponse.toData() = RecommendationsData(
    results = results.map{it.toData()}
)
