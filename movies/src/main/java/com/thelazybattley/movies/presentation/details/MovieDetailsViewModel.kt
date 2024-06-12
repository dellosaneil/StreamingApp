package com.thelazybattley.movies.presentation.details

import androidx.lifecycle.SavedStateHandle
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MovieDetailsEvents, MovieDetailsState>() {

    override fun initialState() = MovieDetailsState()

    private val type =
        savedStateHandle.get<String>(NavScreens.ID)


}
