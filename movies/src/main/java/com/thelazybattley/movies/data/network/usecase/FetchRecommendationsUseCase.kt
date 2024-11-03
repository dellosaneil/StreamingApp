package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.movies.domain.item.recommendations.RecommendationsData

interface FetchRecommendationsUseCase {

    suspend operator fun invoke(id: Int) : Result<RecommendationsData>
}
