package com.thelazybattley.common.domain.usecase

import com.thelazybattley.common.domain.item.genre.Genre
import kotlinx.coroutines.flow.Flow

interface GetGenreListUseCase {

    suspend operator fun invoke() : Result<Flow<List<Genre>>>
}
