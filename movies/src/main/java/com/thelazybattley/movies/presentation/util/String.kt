package com.thelazybattley.movies.presentation.util

import com.thelazybattley.movies.domain.item.movies.MovieGroupType

val String?.toMovieGroupType: MovieGroupType
    get() = run {
        when (this) {
            MovieGroupType.POPULAR.name -> MovieGroupType.POPULAR
            MovieGroupType.UPCOMING.name -> MovieGroupType.UPCOMING
            MovieGroupType.TOP_RATED.name -> MovieGroupType.TOP_RATED
            MovieGroupType.NOW_SHOWING.name -> MovieGroupType.NOW_SHOWING
            MovieGroupType.TRENDING.name -> MovieGroupType.TRENDING
            else -> MovieGroupType.POPULAR
        }
    }
