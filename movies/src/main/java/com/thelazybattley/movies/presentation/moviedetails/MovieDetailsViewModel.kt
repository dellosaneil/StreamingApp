package com.thelazybattley.movies.presentation.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movies.data.network.usecase.FetchMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fetchMovieDetails: FetchMovieDetails
) : BaseViewModel<MovieDetailsEvents, MovieDetailsState>() {

    override fun initialState() = MovieDetailsState()

    private val id =
        savedStateHandle.get<Int>(NavScreens.ID)

    init{
        initialLoad()
    }

    private fun initialLoad() {
        if (id == null) return

        viewModelScope.launch(context = Dispatchers.IO) {
            fetchMovieDetails(id = id)
                .fold(
                    onSuccess = { details ->
                        Timber.d("Test: SUCCESS")
                        updateState { state ->
                            state.copy(
                                movieDetails = details
                            )
                        }
                        Timber.d("Test: ${getCurrentState().movieDetails}")
                    },
                    onFailure = {
                    it.printStackTrace()
                    }
                )
        }
    }
}
