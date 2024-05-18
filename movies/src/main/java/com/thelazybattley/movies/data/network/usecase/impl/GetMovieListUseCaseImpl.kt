package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class GetMovieListUseCaseImpl @Inject constructor(
    private val repository: MoviesRepository
): GetMovieListUseCase {
    override suspend fun invoke(type: MovieGroupType) = repository.getMovieList(type = type)
}
