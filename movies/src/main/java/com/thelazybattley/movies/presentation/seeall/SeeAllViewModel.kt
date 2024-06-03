package com.thelazybattley.movies.presentation.seeall

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movies.data.network.pagination.seeall.SeeAllPagingSource
import com.thelazybattley.movies.data.network.usecase.GetMovieListUseCase
import com.thelazybattley.movies.domain.item.movies.MovieGroupType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieListUseCase: GetMovieListUseCase
) : BaseViewModel<SeeAllEvents, SeeAllUiState>() {

    val movies = Pager(
        config = PagingConfig(pageSize = 15)
    ) {
        SeeAllPagingSource(
            getMovieListUseCase = getMovieListUseCase,
            type = MovieGroupType.fromString(value = type)
        )
    }.flow.cachedIn(scope = viewModelScope)

    private val type =
        savedStateHandle.get<String>(NavScreens.TYPE) ?: MovieGroupType.POPULAR.groupName

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
        }
    }
}
