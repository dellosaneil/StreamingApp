package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.common.domain.item.credits.CreditsData

interface FetchMovieCredits {

    suspend operator fun invoke(id: Int) : Result<CreditsData>

}
