package com.joseangelmaneiro.movies.data.source.remote

import com.joseangelmaneiro.movies.data.Handler
import com.joseangelmaneiro.movies.data.Movie


interface MoviesRemoteDataSource {

    fun getMovies(handler: Handler<List<Movie>>)

}