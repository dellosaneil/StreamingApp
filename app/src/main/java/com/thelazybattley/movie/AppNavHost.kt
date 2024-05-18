package com.thelazybattley.movie

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movie.presentation.dashboard.ui.DashboardScreen
import com.thelazybattley.movies.presentation.seeall.ui.SeeAllScreen

@Composable
fun MyNavHost(
    navHostController: NavHostController
) {
    NavHost(
        startDestination = NavScreens.Dashboard.route,
        navController = navHostController
    ) {
        composable(route = NavScreens.Dashboard.route) {
            DashboardScreen { route ->
                navHostController.navigate(route)
            }
        }
        composable(route = NavScreens.SeeAll.routeWithArgs) {
            SeeAllScreen {
                navHostController.popBackStack()
            }
        }
    }

}
