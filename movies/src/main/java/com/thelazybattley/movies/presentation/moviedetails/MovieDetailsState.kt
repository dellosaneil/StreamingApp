package com.thelazybattley.movies.presentation.moviedetails

import com.thelazybattley.common.presentation.base.BaseUiState

data class MovieDetailsState(
    val isLoading : Boolean = true,
) : BaseUiState
