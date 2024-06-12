package com.thelazybattley.movies.presentation.moviedetails

import androidx.lifecycle.SavedStateHandle
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movies.data.network.usecase.GetMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieDetails: GetMovieDetails
) : BaseViewModel<MovieDetailsEvents, MovieDetailsState>() {

    override fun initialState() = MovieDetailsState()

    private val id =
        savedStateHandle.get<String>(NavScreens.ID)

}
