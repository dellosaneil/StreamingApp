package com.thelazybattley.common.network.repository

import com.thelazybattley.common.domain.item.Genre

interface CommonRepository {

    suspend fun getMoviesGenre() : Result<List<Genre>>
}
