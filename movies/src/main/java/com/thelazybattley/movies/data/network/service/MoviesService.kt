package com.thelazybattley.movies.data.network.service

import com.thelazybattley.movies.data.network.response.movies.MoviesDataResponse
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlaying() : MoviesDataResponse
}
