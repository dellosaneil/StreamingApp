package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.FetchMovieDetails
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class FetchMovieDetailsImpl @Inject constructor(
    private val repository: MoviesRepository
) : FetchMovieDetails {
    override suspend fun invoke(id: Int) = repository.getMovieDetails(id = id)
}
