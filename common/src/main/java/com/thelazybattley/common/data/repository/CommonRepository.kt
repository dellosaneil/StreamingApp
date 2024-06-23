package com.thelazybattley.common.data.repository

import com.thelazybattley.common.domain.item.genre.Genre
import kotlinx.coroutines.flow.Flow

interface CommonRepository {

    suspend fun getGenreList() : Result<Flow<List<Genre>>>

    suspend fun insertGenreList() : Result<Unit>

}
