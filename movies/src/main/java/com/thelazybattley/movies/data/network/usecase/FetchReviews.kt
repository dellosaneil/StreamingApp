package com.thelazybattley.movies.data.network.usecase

import com.thelazybattley.movies.domain.item.reviews.ReviewData

interface FetchReviews {

    suspend operator fun invoke(id: Int) : Result<ReviewData>
}
