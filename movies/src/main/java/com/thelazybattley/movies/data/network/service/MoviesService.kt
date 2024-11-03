package com.thelazybattley.movies.data.network.service

import com.thelazybattley.common.data.network.response.credits.CreditsDataResponse
import com.thelazybattley.movies.data.network.response.moviedetails.MovieDetailsDataResponse
import com.thelazybattley.movies.data.network.response.movies.MoviesDataResponse
import com.thelazybattley.movies.data.network.response.recommendations.RecommendationsDataResponse
import com.thelazybattley.movies.data.network.response.reviews.ReviewDataResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int) : MoviesDataResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int) : MoviesDataResponse

    @GET("movie/top_rated")
    suspend fun getUpcomingMovies(@Query("page") page: Int) : MoviesDataResponse

    @GET("movie/upcoming")
    suspend fun getTopRatedMovies(@Query("page") page: Int) : MoviesDataResponse

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(@Query("page") page: Int) : MoviesDataResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") id: Int) : MovieDetailsDataResponse

    @GET("movie/{id}/credits")
    suspend fun getMovieCredits(@Path("id") id: Int): CreditsDataResponse

    @GET("movie/{id}/recommendations")
    suspend fun getRecommendations(@Path("id") id: Int): RecommendationsDataResponse

    @GET("movie/{id}/reviews")
    suspend fun getReviews(@Path("id") id: Int): ReviewDataResponse

}
