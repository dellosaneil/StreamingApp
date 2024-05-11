package com.thelazybattley.common.network.repository.impl

import com.thelazybattley.common.domain.item.Genre
import com.thelazybattley.common.network.repository.CommonRepository
import com.thelazybattley.common.network.services.CommonService
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val service: CommonService
) : CommonRepository {
    override suspend fun getMoviesGenre() = runCatching {
        service.getMoviesGenre().genres.map { response ->
            Genre(
                id = response.id,
                name = response.name
            )
        }
    }
}
