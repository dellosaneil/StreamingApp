package com.thelazybattley.common.domain.usecase.impl

import com.thelazybattley.common.data.repository.CommonRepository
import com.thelazybattley.common.domain.usecase.InsertGenreList
import javax.inject.Inject

class InsertGenreListImpl @Inject constructor(
    private val commonRepository: CommonRepository
): InsertGenreList {
    override suspend fun invoke() = commonRepository.insertGenreList()
}
