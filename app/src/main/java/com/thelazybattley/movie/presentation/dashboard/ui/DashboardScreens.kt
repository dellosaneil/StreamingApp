package com.thelazybattley.movie.presentation.dashboard.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.thelazybattley.movie.R

sealed class DashboardScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    data object Home : DashboardScreens("home", R.string.home, Icons.Filled.Home)
    data object Search :
        DashboardScreens("search", R.string.search, Icons.Filled.Search)

    data object Favorites :
        DashboardScreens("favorites", R.string.favorites, Icons.Filled.Favorite)
}
