package com.thelazybattley.movies.data.network.response.nowplaying

import com.thelazybattley.movies.data.network.response.movie.MovieResponse

data class NowPlayingDataResponse(
    val dates: NowPlayingDatesResponse,
    val page: Int,
    val results: List<MovieResponse>,
    val totalPages: Int,
    val totalResults: Int
)
