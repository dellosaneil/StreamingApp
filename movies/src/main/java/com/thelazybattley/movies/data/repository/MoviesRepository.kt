package com.thelazybattley.movies.data.repository

import com.thelazybattley.movies.data.item.movies.MoviesData

interface MoviesRepository {

    suspend fun getNowPlaying(): Result<MoviesData>
}
