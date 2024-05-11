package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.movies.data.item.movies.MovieListType
import com.thelazybattley.movies.data.item.movies.MoviesData

interface GetMovieListUseCase {

    suspend operator fun invoke(type: MovieListType) : Result<MoviesData>

}
