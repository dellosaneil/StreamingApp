package com.thelazybattley.common.domain.usecase

import com.thelazybattley.common.domain.item.Genre

interface GetGenreList {

    suspend operator fun invoke() : Result<List<Genre>>
}
