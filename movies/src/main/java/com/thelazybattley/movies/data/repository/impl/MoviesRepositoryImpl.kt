package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.movies.data.network.service.MoviesService
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService
) : MoviesRepository {
    override suspend fun getNowPlaying() = runCatching {
        moviesService.getNowPlaying()
    }
}
