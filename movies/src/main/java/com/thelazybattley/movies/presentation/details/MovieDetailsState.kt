package com.thelazybattley.movies.presentation.details

import com.thelazybattley.common.presentation.base.BaseUiState

data class MovieDetailsState(
    val isLoading : Boolean = true,
) : BaseUiState
