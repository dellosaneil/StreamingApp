package com.thelazybattley.movies.presentation.seeall

import androidx.lifecycle.SavedStateHandle
import com.thelazybattley.common.presentation.base.BaseViewModel
import com.thelazybattley.common.presentation.navigation.NavScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<SeeAllEvents, SeeAllUiState>() {

    private val type = savedStateHandle.get<String>(NavScreens.TYPE)

    override fun initialState() = SeeAllUiState()

    init {
        Timber.d("Test: $type")
    }


}
