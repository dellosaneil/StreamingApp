package com.thelazybattley.movie.presentation.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.thelazybattley.common.presentation.theme.colors
import com.thelazybattley.common.presentation.theme.textStyle

@Composable
fun DashboardBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val items = listOf(
        DashboardScreens.Home,
        DashboardScreens.Search,
        DashboardScreens.Favorites,
    )

    BottomNavigation(
        modifier = modifier,
        backgroundColor = colors.white1,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        val color = if (isSelected) {
                            colors.red1
                        } else {
                            colors.gray1
                        }

                        Icon(
                            imageVector = screen.icon, contentDescription = null,
                            tint = color
                        )
                        Text(
                            text = stringResource(id = screen.resourceId),
                            style = textStyle.urbanist.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp,
                                color = color
                            )
                        )
                    }
                }
            )
        }

    }
}
