package com.thelazybattley.movies.presentation.seeall

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
`import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel<SeeAllEvents, SeeAllUiState>() {

    private val type = savedStateHandle.get<String>(NavScreens.TYPE) ?: MovieGroupType.POPULAR.groupName

    override fun initialState() = SeeAllUiState()

    init {
        updateMovieGroupType()
    }

    private fun updateMovieGroupType() {
        viewModelScope.launch(context = Dispatchers.IO) {
            val movieGroupType = MovieGroupType.fromString(value = type)
            updateState { state ->
                state.copy(movieGroupType = movieGroupType)
            }
            getInitialMovies()
        }
    }

    private fun getInitialMovies() {
        viewModelScope.launch(context = Dispatchers.IO) {
            getMovieListUseCase(MovieGroupType.fromString(value = type)).fold(
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
