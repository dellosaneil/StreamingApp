package com.thelazybattley.common.domain.usecase.impl

import com.thelazybattley.common.domain.usecase.GetGenreList
import com.thelazybattley.common.network.repository.CommonRepository
import javax.inject.Inject

class GetGenreListImpl @Inject constructor(
    private val repository: CommonRepository
) : GetGenreList {
    override suspend fun invoke() = repository.getMoviesGenre()
}
