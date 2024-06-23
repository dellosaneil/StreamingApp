package com.thelazybattley.common.domain.item.credits

data class CreditsCrew(
    val creditId: String,
    val department: String,
    val id: Int,
    val job: String,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val profilePath: String
)
