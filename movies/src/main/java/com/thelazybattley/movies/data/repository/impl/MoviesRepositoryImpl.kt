package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.common.domain.usecase.GetImageFromPath
import com.thelazybattley.movies.data.network.response.movies.toData
import com.thelazybattley.movies.data.network.service.MoviesService
import com.thelazybattley.movies.data.repository.MoviesRepository
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.domain.item.movies.MoviesData
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val getImageFromPath: GetImageFromPath
) : MoviesRepository {

    override suspend fun getMovieList(type: MovieGroupType) = runCatching {
        val response = when (type) {
            MovieGroupType.POPULAR -> moviesService
                .getPopularMovies()

            MovieGroupType.TOP_RATED -> moviesService
                .getTopRatedMovies()

            MovieGroupType.NOW_SHOWING -> moviesService
                .getNowPlayingMovies()

            MovieGroupType.UPCOMING -> moviesService
                .getUpcomingMovies()

            MovieGroupType.TRENDING -> moviesService
                .getTrendingMovies()
        }

        MoviesData(
            results = response
                .results
                .filter {
                    it.backdropPath != null && it.posterPath != null
                }
                .map { item ->
                    item
                        .toData()
                        .copy(
                            posterImage = getImageFromPath(
                                path = item.posterPath!!
                            ),
                            backdropImage = getImageFromPath(
                                path = item.backdropPath!!
                            )
                        )
                }
        )
    }
}
