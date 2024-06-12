package com.thelazybattley.movies.domain.item.moviedetails

data class MovieDetailsData(
    val backdropPath: String,
    val budget: Int,
    val genres: List<MovieDetailsGenre>,
    val homepage: String,
    val id: Int,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<MovieDetailsProductionCompany>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<MovieDetailsSpokenLanguage>,
    val status: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Int,
    val voteCount: Int
)
