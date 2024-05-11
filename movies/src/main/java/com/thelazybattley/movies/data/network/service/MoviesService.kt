package com.thelazybattley.movies.data.network.service

import com.thelazybattley.movies.data.network.response.movies.MoviesDataResponse
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : MoviesDataResponse

    @GET("movie/popular")
    suspend fun getPopularMovies() : MoviesDataResponse

    @GET("movie/top_rated")
    suspend fun getUpcomingMovies() : MoviesDataResponse

    @GET("movie/upcoming")
    suspend fun getTopRatedMovies() : MoviesDataResponse

    @GET("trending/movie/week")
    suspend fun getTrendingMovies() : MoviesDataResponse
}
