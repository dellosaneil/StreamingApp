package com.thelazybattley.common.domain.usecase

import com.thelazybattley.common.domain.item.Genre

interface GetGenreListUseCase {

    suspend operator fun invoke() : Result<List<Genre>>
}
