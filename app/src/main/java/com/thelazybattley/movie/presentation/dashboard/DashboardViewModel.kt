package com.thelazybattley.movie.presentation.dashboard

import androidx.lifecycle.viewModelScope
import com.thelazybattley.common.base.BaseViewModel
import com.thelazybattley.movies.data.network.usecase.GetNowPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getNowPlayingUseCase: GetNowPlayingUseCase
) : BaseViewModel<DashboardEvent, DashboardUiState>() {

    override fun initialState() = DashboardUiState()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(context = Dispatchers.IO) {
            getNowPlayingUseCase()
                .fold(
                    onSuccess = { data ->
                        updateState { state ->
                            state.copy(
                                nowPlayingMovies = data.results.take(n = 10)
                            )
                        }
                    },
                    onFailure = {
                        it.printStackTrace()
                    }
                )
        }
    }
}
