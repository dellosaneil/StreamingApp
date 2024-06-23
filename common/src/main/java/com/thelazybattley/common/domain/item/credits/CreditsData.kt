package com.thelazybattley.common.domain.item.credits

data class CreditsData(
    val cast: List<CreditsCast>,
    val crew: List<CreditsCrew>,
    val id: Int
)
