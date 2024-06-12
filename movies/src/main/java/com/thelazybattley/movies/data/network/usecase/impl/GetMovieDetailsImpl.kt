package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.GetMovieDetails
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class GetMovieDetailsImpl @Inject constructor(
    private val repository: MoviesRepository
) : GetMovieDetails {
    override suspend fun invoke(id: Int) = repository.getMovieDetails(id = id)
}
