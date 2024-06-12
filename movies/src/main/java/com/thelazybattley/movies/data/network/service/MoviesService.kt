package com.thelazybattley.movies.data.network.service

import com.thelazybattley.movies.data.network.response.moviedetails.MovieDetailsDataResponse
import com.thelazybattley.movies.data.network.response.movies.MoviesDataResponse
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

}
