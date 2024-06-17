package com.thelazybattley.movie

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.thelazybattley.common.presentation.navigation.NavScreens
import com.thelazybattley.movie.presentation.dashboard.ui.DashboardScreen
import com.thelazybattley.movies.presentation.moviedetails.ui.MovieDetailsScreen
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
            SeeAllScreen(
                onNavigate = { route ->
                    navHostController.navigate(route)
                }
            ) {
                navHostController.popBackStack()
            }
        }
        composable(
            route = NavScreens.MovieDetails.routeWithArgs,
            arguments = listOf(
                navArgument(name = NavScreens.ID) { type = NavType.IntType }
            )
        ) {
            MovieDetailsScreen(
                onNavigate = { route ->
                    navHostController.navigate(route)
                }
            ) {
                navHostController.popBackStack()
            }
        }
    }
}
