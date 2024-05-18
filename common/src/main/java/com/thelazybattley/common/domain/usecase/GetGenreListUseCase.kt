package com.thelazybattley.common.domain.usecase

import com.thelazybattley.common.domain.item.Genre
import kotlinx.coroutines.flow.Flow

interface GetGenreListUseCase {

    suspend operator fun invoke() : Result<Flow<List<Genre>>>
}
