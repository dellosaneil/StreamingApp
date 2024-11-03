package com.thelazybattley.movies.presentation.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movies.data.network.usecase.FetchMovieCredits
import com.thelazybattley.movies.data.network.usecase.FetchMovieDetails
import com.thelazybattley.movies.data.network.usecase.FetchRecommendationsUseCase
import com.thelazybattley.movies.data.network.usecase.FetchReviews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fetchMovieDetails: FetchMovieDetails,
    private val fetchMovieCredits: FetchMovieCredits,
    private val fetchRecommendationsUseCase: FetchRecommendationsUseCase,
    private val fetchReviews: FetchReviews

) : BaseViewModel<MovieDetailsEvents, MovieDetailsState>(), MovieDetailsCallbacks {

    override fun initialState() = MovieDetailsState()

    private val id =
        savedStateHandle.get<Int>(NavScreens.ID)

    init {
        initialLoad()
    }

    private fun initialLoad() {
        if (id == null) return

        viewModelScope.launch(context = Dispatchers.IO) {
            fetchMovieDetails(id = id)
                .fold(
                    onSuccess = { details ->
                        updateState { state ->
                            state.copy(
                                movieDetails = details
                            )
                        }
                    },
                    onFailure = {
                        it.printStackTrace()
                    }
                )
        }

        viewModelScope.launch(context = Dispatchers.IO) {
            fetchMovieCredits(id = id)
                .fold(
                    onSuccess = { credits ->
                        updateState { state ->
                            state.copy(
                                credits = credits.copy(
                                    cast = credits.cast
                                        .distinctBy { it.id }
                                        .filter { it.profilePath.isNotEmpty() }
                                        .sortedBy { it.order }
                                        .take(8),
                                    crew = credits.crew
                                        .distinctBy { it.id }
                                        .filter { crew -> crew.knownForDepartment == "Directing" }
                                )
                            )
                        }
                    },
                    onFailure = {

                    }
                )

        }
        viewModelScope.launch(context = Dispatchers.IO) {
            fetchRecommendationsUseCase(id = id)
                .fold(
                    onSuccess = { recommendations ->
                        updateState { state ->
                            state.copy(
                                recommendations = recommendations
                            )
                        }
                    },
                    onFailure = {

                    }
                )
        }
        viewModelScope.launch(context = Dispatchers.IO) {
            fetchReviews(id = id)
                .fold(
                    onSuccess =  { reviews ->
                        updateState { state ->
                            state.copy(
                                reviews = reviews
                            )
                        }
                    },
                    onFailure = {

                    }
                )
        }
    }

    override fun hasTextOverflow(hasTextOverflow: Boolean) {
        updateState { state ->
            state.copy(
                hasTextOverflow = hasTextOverflow
            )
        }
    }


    override fun showMoreTextClicked() {
        updateState { state ->
            state.copy(
                maxLines = Int.MAX_VALUE
            )
        }
    }

}
