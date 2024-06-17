package com.thelazybattley.movies.data.network.response.moviedetails

import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsData
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsGenre
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsProductionCompany
import com.thelazybattley.movies.domain.item.moviedetails.MovieDetailsSpokenLanguage

data class MovieDetailsDataResponse(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<MovieDetailsGenreResponse>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<MovieDetailsProductionCompanyResponse>,
    val productionCountries: List<MovieDetailsProductionCountryResponse>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<MovieDetailsSpokenLanguageResponse>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

val MovieDetailsDataResponse.toData
    get() = run {
        MovieDetailsData(
            backdropImage = backdropPath,
            budget = budget,
            genres = genres.map { response ->
                MovieDetailsGenre(
                    id = response.id,
                    name = response.name
                )
            },
            homepage = homepage,
            id = id,
            originCountry = originCountry,
            originalTitle = originalTitle,
            originalLanguage = originalLanguage,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            productionCompanies = productionCompanies.map { response ->
                MovieDetailsProductionCompany(
                    id = response.id,
                    name = response.name,
                    originCountry = response.originCountry
                )
            },
            releaseDate = releaseDate,
            revenue = revenue,
            runtime = runtime,
            status = status,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount,
            spokenLanguages = spokenLanguages.map { response ->
                MovieDetailsSpokenLanguage(
                    englishName = response.englishName,
                    name = response.name
                )
            },
            releaseYear = releaseDate.split("-").first().toInt()
        )
    }
