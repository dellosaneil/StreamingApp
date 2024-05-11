package com.thelazybattley.movies.data.network.usecase.impl

import com.thelazybattley.movies.data.network.usecase.GetNowPlayingUseCase
import com.thelazybattley.movies.data.repository.MoviesRepository
import javax.inject.Inject

class GetNowPlayingUseCaseImpl @Inject constructor(
    private val repository: MoviesRepository
): GetNowPlayingUseCase {
    override suspend fun invoke() = repository.getNowPlaying()
}
