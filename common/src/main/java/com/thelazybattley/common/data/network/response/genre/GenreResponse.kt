package com.thelazybattley.common.data.network.response.genre

import com.thelazybattley.common.domain.item.Genre

data class GenreResponse(
    val id: Int,
    val name: String
)

fun GenreResponse.toData() = Genre(
    id = id,
    name = name
)
