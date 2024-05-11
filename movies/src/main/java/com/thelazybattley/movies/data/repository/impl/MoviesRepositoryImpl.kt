package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.common.usecase.GetImageFromPath
import com.thelazybattley.movies.data.item.movies.MoviesData
import com.thelazybattley.movies.data.network.response.movies.toData
import com.thelazybattley.movies.data.network.service.MoviesService
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val getImageFromPath: GetImageFromPath
) : MoviesRepository {

    companion object {
        private const val POSTER_WIDTH  = 400
    }

    override suspend fun getNowPlaying() = runCatching {
        MoviesData(
            results = moviesService
                .getNowPlaying()
                .results
                .map { response ->
                    response.toData().copy(
                        posterImage = getImageFromPath(
                            path = response.posterPath,
                            width = POSTER_WIDTH
                        )
                    )
                }
        )
    }
}
