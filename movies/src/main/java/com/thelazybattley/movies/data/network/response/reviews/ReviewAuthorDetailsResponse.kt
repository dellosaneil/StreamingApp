package com.thelazybattley.movies.data.network.response.reviews

import com.thelazybattley.movies.domain.item.reviews.ReviewAuthorDetails

data class ReviewAuthorDetailsResponse(
    val avatarPath: String,
    val name: String,
    val rating: Int,
    val username: String
)

fun ReviewAuthorDetailsResponse.toData() = ReviewAuthorDetails(
    avatarPath = avatarPath,
    rating = rating
)
