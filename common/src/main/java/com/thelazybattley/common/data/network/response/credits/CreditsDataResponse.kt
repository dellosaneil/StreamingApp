package com.thelazybattley.common.data.network.response.credits

import com.thelazybattley.common.domain.item.credits.CreditsCast
import com.thelazybattley.common.domain.item.credits.CreditsCrew
import com.thelazybattley.common.domain.item.credits.CreditsData

data class CreditsDataResponse(
    val cast: List<CreditsCastResponse>,
    val crew: List<CreditsCrewResponse>,
    val id: Int
)

val CreditsDataResponse.toData
    get() = run {
        CreditsData(
            id = id,
            cast = cast.map { response ->
                CreditsCast(
                    castId = response.castId,
                    character = response.character,
                    creditId = response.creditId,
                    name = response.name,
                    order = response.order,
                    knownForDepartment = response.knownForDepartment,
                    profilePath = response.profilePath.orEmpty(),
                    id = response.id,
                    originalName = response.originalName
                )
            },
            crew = crew.map { response ->
                CreditsCrew(
                    creditId = response.creditId,
                    department = response.department,
                    job = response.job,
                    name = response.name,
                    profilePath = response.profilePath.orEmpty(),
                    id = response.id,
                    knownForDepartment = response.knownForDepartment,
                    originalName = response.originalName
                )
            }
        )
    }
