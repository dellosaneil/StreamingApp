package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.common.domain.usecase.GetImageFromPath
import com.thelazybattley.movies.data.network.response.moviedetails.toData
import com.thelazybattley.movies.data.network.response.movies.toData
import com.thelazybattley.movies.data.network.service.MoviesService
import com.thelazybattley.movies.data.repository.MoviesRepository
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.domain.item.movies.MoviesData
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    private val getImageFromPath: GetImageFromPath
) : MoviesRepository {

    override suspend fun getMovieList(type: MovieGroupType, page: Int): Result<MoviesData> =
        runCatching {
            val response = when (type) {
                MovieGroupType.POPULAR -> moviesService
                    .getPopularMovies(page = page)

                MovieGroupType.TOP_RATED -> moviesService
                    .getTopRatedMovies(page = page)

                MovieGroupType.NOW_SHOWING -> moviesService
                    .getNowPlayingMovies(page = page)

                MovieGroupType.UPCOMING -> moviesService
                    .getUpcomingMovies(page = page)

                MovieGroupType.TRENDING -> moviesService
                    .getTrendingMovies(page = page)
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

    override suspend fun getMovieDetails(id: Int): Result<MovieDetailsData> =
        runCatching {
            val response = moviesService.getMovieDetails(id = id)
            response.toData
        }
}
