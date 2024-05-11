package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.common.domain.usecase.GetImageFromPath
import com.thelazybattley.movies.domain.item.movies.MovieListType
import com.thelazybattley.movies.domain.item.movies.MoviesData
import com.thelazybattley.movies.data.network.response.movies.toData
import com.thelazybattley.movies.data.network.service.MoviesService
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val getImageFromPath: GetImageFromPath
) : MoviesRepository {

    override suspend fun getMovieList(type: MovieListType) = runCatching {
        val response = when (type) {
            MovieListType.POPULAR -> moviesService
                .getPopularMovies()
            MovieListType.TOP_RATED -> moviesService
                .getTopRatedMovies()
            MovieListType.NOW_SHOWING -> moviesService
                .getNowPlayingMovies()
            MovieListType.UPCOMING -> moviesService
                .getUpcomingMovies()
            MovieListType.TRENDING -> moviesService
                .getTrendingMovies()
        }

        MoviesData(
            results = response
                .results
                .map { item ->
                    item.toData().copy(
                        posterImage = getImageFromPath(
                            path = item.posterPath
                        ),
                        backdropImage = getImageFromPath(
                            path = item.backdropPath ?: ""
                        )
                    )
                }
        )
    }
}
