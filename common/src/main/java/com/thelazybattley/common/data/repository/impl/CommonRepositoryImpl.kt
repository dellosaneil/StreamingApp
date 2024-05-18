package com.thelazybattley.common.data.repository.impl

import com.thelazybattley.common.data.network.local.genre.GenreDao
import com.thelazybattley.common.data.network.local.genre.toData
import com.thelazybattley.common.data.network.response.genre.toData
import com.thelazybattley.common.data.network.services.CommonService
import com.thelazybattley.common.data.repository.CommonRepository
import com.thelazybattley.common.domain.item.toEntity
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val service: CommonService,
    private val genreDao: GenreDao
) : CommonRepository {
    override suspend fun getGenreList() = runCatching {
        genreDao
            .getAll()
            .map { entities ->
                entities.map { entity ->
                    entity.toData()
                }
            }
    }

    override suspend fun insertGenreList(): Result<Unit> = runCatching {
        service
            .getMoviesGenre()
            .genres
            .map { response ->
                response
                    .toData()
                    .toEntity()
            }
            .also { entity ->

                genreDao.insertAll(entity)
            }
    }
}
