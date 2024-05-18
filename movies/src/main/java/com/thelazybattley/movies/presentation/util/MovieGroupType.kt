package com.thelazybattley.movies.presentation.util

import com.thelazybattley.movies.domain.item.movies.MovieGroupType

val MovieGroupType.text
    get() = run {
        when(this) {
            MovieGroupType.POPULAR -> com.thelazybattley.common.R.string.popular_movies
            MovieGroupType.TOP_RATED -> com.thelazybattley.common.R.string.top_rated_movies
            MovieGroupType.NOW_SHOWING -> com.thelazybattley.common.R.string.now_showing
            MovieGroupType.UPCOMING -> com.thelazybattley.common.R.string.upcoming_movies
            MovieGroupType.TRENDING -> com.thelazybattley.common.R.string.trending_movies
        }
    }
