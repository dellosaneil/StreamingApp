package com.thelazybattley.common.domain.usecase

interface GetImageFromPath {

    operator fun invoke(path: String) : String
}
