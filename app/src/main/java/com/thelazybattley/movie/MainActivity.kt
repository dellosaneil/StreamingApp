package com.thelazybattley.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.thelazybattley.common.theme.MovieTheme
import com.thelazybattley.movies.data.network.usecase.GetNowPlayingUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var useCase: GetNowPlayingUseCase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            useCase()

        }
        setContent {
            val navHost = rememberNavController()

            MovieTheme {
                MyNavHost(navHostController = navHost)
            }
        }
    }
}
