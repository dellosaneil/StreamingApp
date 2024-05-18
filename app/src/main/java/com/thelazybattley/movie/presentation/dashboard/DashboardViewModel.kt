package com.thelazybattley.movie.presentation.dashboard

import androidx.lifecycle.viewModelScope
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.domain.item.movies.MovieListType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel<DashboardEvent, DashboardUiState>() {

    override fun initialState() = DashboardUiState()

    init {
        fetchData()
    }

    private fun fetchData() {
        val movieTypes = MovieListType.entries.toTypedArray()
        movieTypes.forEach { type ->
            viewModelScope.launch(context = Dispatchers.IO) {
                getMovieListUseCase(type = type)
                    .fold(
                        onSuccess = { data ->
                            updateState { state ->
                                val results = data.results.take(10)
                                when (type) {
                                    MovieListType.POPULAR -> state.copy(
                                        popularMovies = results
                                    )

                                    MovieListType.TOP_RATED -> state.copy(
                                        topRatedMovies = results
                                    )

                                    MovieListType.NOW_SHOWING -> state.copy(
                                        nowShowingMovies = results
                                    )

                                    MovieListType.UPCOMING -> state.copy(
                                        upcomingMovies = results
                                    )

                                    MovieListType.TRENDING -> state.copy(
                                        trendingMovies = results,
                                        highlightedMovie = results.first()
                                    )
                                }
                            }
                        },
                        onFailure = {
                            it.printStackTrace()
                        }
                    )
            }
        }

    }
}
