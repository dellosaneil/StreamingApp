package com.thelazybattley.common.domain.item.credits

data class CreditsCast(
    val castId: Int,
    val character: String,
    val creditId: String,
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val order: Int,
    val originalName: String,
    val profilePath: String
)
