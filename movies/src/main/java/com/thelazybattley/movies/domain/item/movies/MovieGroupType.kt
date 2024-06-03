package com.thelazybattley.movies.domain.item.movies

enum class MovieGroupType(val groupName: String) {
    POPULAR(groupName = "popular"),
    TOP_RATED(groupName = "top_rated"),
    NOW_SHOWING(groupName = "now_playing"),
    UPCOMING(groupName = "upcoming"),
    TRENDING(groupName = "trending");

    override fun toString(): String {
        return groupName
    }

    companion object {
        fun fromString(value: String) = entries.first { it.groupName == value }
    }

}
