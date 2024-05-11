package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.movies.data.item.movies.MoviesData

interface GetNowPlayingUseCase {

    suspend operator fun invoke() : Result<MoviesData>

}
