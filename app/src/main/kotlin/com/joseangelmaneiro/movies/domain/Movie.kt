package com.joseangelmaneiro.movies.domain


// Movie in the domain layer
data class Movie (
        val id: Int,
        val voteAverage: String,
        val title: String,
        val posterPath: String,
        val backdropPath: String?,
        val overview: String,
        val releaseDate: String)