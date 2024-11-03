package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.FetchRecommendationsUseCase
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class FetchRecommendationsUseCaseImpl @Inject constructor(
    private val repository: MoviesRepository
): FetchRecommendationsUseCase {
    override suspend fun invoke(id: Int) = repository.fetchRecommendations(id = id)
}
