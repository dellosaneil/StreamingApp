package com.thelazybattley.movies.data.repository

import com.thelazybattley.movies.domain.item.movies.MovieListType
import com.thelazybattley.movies.domain.item.movies.MoviesData

interface MoviesRepository {

    suspend fun getMovieList(type: MovieListType): Result<MoviesData>
}
