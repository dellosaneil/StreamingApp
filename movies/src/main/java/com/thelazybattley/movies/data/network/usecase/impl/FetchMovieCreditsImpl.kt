package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.FetchMovieCredits
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class FetchMovieCreditsImpl @Inject constructor(
    private val repository: MoviesRepository
): FetchMovieCredits {
    override suspend fun invoke(id: Int) = repository.getMovieCredits(id = id)
}
