package com.thelazybattley.common.data.network.local.genre

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thelazybattley.common.domain.item.genre.Genre

@Entity(tableName = "genre")
data class GenreEntity(
    @PrimaryKey val id: Int,
    val name: String
)

fun GenreEntity.toData() = Genre(id = id, name = name)
