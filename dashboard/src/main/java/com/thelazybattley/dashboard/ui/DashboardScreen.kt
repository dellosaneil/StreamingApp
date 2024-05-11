package com.thelazybattley.dashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thelazybattley.common.theme.LocalColors
import com.thelazybattley.common.theme.MovieTheme

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalColors.current.white1)
    ) {

    }


}


@Preview
@Composable
private fun PreviewDashboard() {
    MovieTheme {
        DashboardScreen()
    }
}
