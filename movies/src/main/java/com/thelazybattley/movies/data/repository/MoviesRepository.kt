package com.thelazybattley.movies.data.repository

import com.thelazybattley.movies.data.network.response.nowplaying.NowPlayingDataResponse

interface MoviesRepository {

    suspend fun getNowPlaying(): Result<NowPlayingDataResponse>
}
