package com.thelazybattley.movies.presentation.moviedetails

import com.thelazybattley.common.presentation.base.BaseUiState
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData

data class MovieDetailsState(
    val isLoading : Boolean = true,
    val movieDetails : MovieDetailsData? = null,
    val maxLines: Int = 3,
    val hasTextOverflow: Boolean = false
) : BaseUiState
