package com.thelazybattley.movies.data.repository.impl

import com.thelazybattley.common.data.network.response.credits.toData
import com.thelazybattley.common.domain.item.credits.CreditsData
import com.thelazybattley.common.domain.usecase.GetImageFromPath
import com.thelazybattley.movies.data.network.response.moviedetails.toData
import com.thelazybattley.movies.data.network.response.movies.toData
import com.thelazybattley.movies.data.network.response.recommendations.toData
import com.thelazybattley.movies.data.network.response.reviews.toData
import com.thelazybattley.movies.data.network.service.MoviesService
import com.thelazybattley.movies.data.repository.MoviesRepository
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.domain.item.movies.MoviesData
import com.thelazybattley.movies.domain.item.recommendations.RecommendationsData
import com.thelazybattley.movies.domain.item.reviews.ReviewData
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
                .copy(
                    backdropImage = getImageFromPath(
                        path = response.backdropPath
                    )
                )
        }

    override suspend fun getMovieCredits(id: Int): Result<CreditsData> = runCatching {
        val response = moviesService.getMovieCredits(id = id)
        response.toData
            .copy(
                cast = response.toData.cast.map { cast ->
                    cast.copy(
                        profilePath = run {
                            if (cast.profilePath.isNotEmpty()) getImageFromPath(path = cast.profilePath) else ""
                        }
                    )
                },
                crew = response.toData.crew.map { crew ->
                    crew.copy(
                        profilePath = run {
                            if (crew.profilePath.isNotEmpty()) getImageFromPath(path = crew.profilePath) else ""
                        }
                    )
                }
            )
    }

    override suspend fun fetchRecommendations(id: Int): Result<RecommendationsData> =
        runCatching {
            val results = moviesService
                .getRecommendations(id)
                .results
                .filter {
                    it.posterPath != null
                }.map {
                    it.toData()
                        .copy(
                            posterImage = getImageFromPath(it.posterPath!!)
                        )
                }
            RecommendationsData(results = results)
        }

    override suspend fun fetchReviews(id: Int) = runCatching {
        val response = moviesService.getReviews(id = id)

        ReviewData(
            id = response.id,
            results = response.results.map { result ->
                result.toData()
                    .copy(
                        authorDetails = result.authorDetails.copy(
                            avatarPath = getImageFromPath(result.authorDetails.avatarPath)
                        ).toData()
                    )
            },
            totalResults = response.id
        )

    }

}
