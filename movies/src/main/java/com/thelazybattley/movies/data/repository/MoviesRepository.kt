package com.thelazybattley.movies.data.repository

import com.thelazybattley.movies.data.item.movies.MovieListType
import com.thelazybattley.movies.data.item.movies.MoviesData

interface MoviesRepository {

    suspend fun getMovieList(type: MovieListType): Result<MoviesData>
}
