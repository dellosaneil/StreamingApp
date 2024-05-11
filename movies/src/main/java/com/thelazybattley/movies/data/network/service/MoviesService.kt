package com.thelazybattley.movies.data.network.service

import com.thelazybattley.movies.data.network.response.nowplaying.NowPlayingDataResponse
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlaying() : NowPlayingDataResponse
}
