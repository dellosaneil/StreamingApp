package com.thelazybattley.common.domain.usecase

interface InsertGenreList {

    suspend operator fun invoke() : Result<Unit>

}
