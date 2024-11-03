package com.thelazybattley.movies.presentation.moviedetails

import com.thelazybattley.common.domain.item.credits.CreditsData
import com.thelazybattley.common.presentation.base.BaseUiState
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData
import com.thelazybattley.movies.domain.item.recommendations.RecommendationsData

data class MovieDetailsState(
    val isLoading : Boolean = true,
    val movieDetails : MovieDetailsData? = null,
    val maxLines: Int = 3,
    val hasTextOverflow: Boolean = false,
    val credits: CreditsData? = null,
    val recommendations: RecommendationsData? = null
) : BaseUiState
