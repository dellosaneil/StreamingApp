package com.thelazybattley.movies.data.repository

import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.domain.item.movies.MoviesData

interface MoviesRepository {

    suspend fun getMovieList(type: MovieGroupType): Result<MoviesData>
}
