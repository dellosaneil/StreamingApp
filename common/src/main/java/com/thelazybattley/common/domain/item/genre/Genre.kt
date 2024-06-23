package com.thelazybattley.common.domain.item.genre

import com.thelazybattley.common.data.network.local.genre.GenreEntity

data class Genre(
    val id: Int,
    val name: String
)

fun Genre.toEntity() = GenreEntity(
    id = id,
    name = name
)
