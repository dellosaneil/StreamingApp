package com.thelazybattley.common.domain.usecase.impl

import com.thelazybattley.common.domain.usecase.GetGenreListUseCase
import com.thelazybattley.common.data.repository.CommonRepository
import javax.inject.Inject

class GetGenreListUseCaseImpl @Inject constructor(
    private val repository: CommonRepository
) : GetGenreListUseCase {
    override suspend fun invoke() = repository.getMoviesGenre()
}
