package com.thelazybattley.movies.presentation.seeall

import com.thelazybattley.common.presentation.base.BaseUiState
import com.thelazybattley.movies.domain.item.movies.MovieGroupType

data class SeeAllUiState(
    val isLoading: Boolean = true,
    val movieGroupType: MovieGroupType? = null,
) : BaseUiState
