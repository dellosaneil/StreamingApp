package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.common.usecase.GetImageFromPath
import com.thelazybattley.movies.data.item.movies.MovieListType
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
        private const val POSTER_WIDTH = 400
    }

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
        }

        MoviesData(
            results = response
                .results
                .map { item ->
                    item.toData().copy(
                        posterImage = getImageFromPath(
                            path = item.posterPath,
                            width = POSTER_WIDTH
                        )
                    )
                }
        )
    }
}
