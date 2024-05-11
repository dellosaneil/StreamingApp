package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.movies.data.network.response.nowplaying.NowPlayingDataResponse

interface GetNowPlayingUseCase {

    suspend operator fun invoke() : Result<NowPlayingDataResponse>

}
