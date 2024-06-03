package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.data.repository.MoviesRepository
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import com.thelazybattley.movies.domain.item.movies.MoviesData
import javax.inject.Inject

class GetMovieListUseCaseImpl @Inject constructor(
    private val repository: MoviesRepository
): GetMovieListUseCase {
    override suspend fun invoke(type: MovieGroupType, page: Int): Result<MoviesData> = repository.getMovieList(type = type, page = page)
}
