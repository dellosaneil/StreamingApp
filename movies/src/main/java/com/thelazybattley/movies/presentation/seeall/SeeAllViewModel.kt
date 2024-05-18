package com.thelazybattley.movies.presentation.seeall

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.presentation.util.toMovieGroupType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel<SeeAllEvents, SeeAllUiState>() {

    private val type = savedStateHandle.get<String>(NavScreens.TYPE)

    override fun initialState() = SeeAllUiState()

    init {
        updateMovieGroupType()
    }

    private fun updateMovieGroupType() {
        viewModelScope.launch(context = Dispatchers.IO) {
            val movieGroupType = type.toMovieGroupType
            updateState { state ->
                state.copy(movieGroupType = movieGroupType)
            }
            getInitialMovies()
        }
    }

    private fun getInitialMovies() {
        viewModelScope.launch(context = Dispatchers.IO) {
            getMovieListUseCase(type.toMovieGroupType).fold(
                onSuccess = { moviesData ->
                    updateState { state ->
                        state.copy(
                            movies = moviesData.results
                        )
                    }
                },
                onFailure = {

                }
            )
        }
    }
}
