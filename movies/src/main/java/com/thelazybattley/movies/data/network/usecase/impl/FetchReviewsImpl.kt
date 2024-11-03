package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.FetchReviews
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class FetchReviewsImpl @Inject constructor(
    private val repository: MoviesRepository
): FetchReviews {
    override suspend fun invoke(id: Int) = repository.fetchReviews(id = id)
}
