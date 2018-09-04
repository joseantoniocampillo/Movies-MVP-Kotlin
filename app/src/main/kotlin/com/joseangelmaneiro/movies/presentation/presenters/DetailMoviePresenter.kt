package com.joseangelmaneiro.movies.presentation.presenters

import com.joseangelmaneiro.movies.domain.Handler
import com.joseangelmaneiro.movies.domain.Movie
import com.joseangelmaneiro.movies.domain.MoviesRepository
import com.joseangelmaneiro.movies.presentation.DetailMovieView
import com.joseangelmaneiro.movies.presentation.formatters.Formatter
import java.lang.ref.WeakReference


class DetailMoviePresenter(private val repository: MoviesRepository,
                           private val formatter: Formatter,
                           private val movieId: Int) : Handler<Movie> {

    private lateinit var view: WeakReference<DetailMovieView>
    

    fun setView(detailMovieView: DetailMovieView) {
        view = WeakReference(detailMovieView)
    }

    fun viewReady() {
        repository.getMovie(movieId, this)
    }

    override fun handle(movie: Movie) {
        view.get()?.let { detailMovieView ->
            detailMovieView.displayImage(formatter.getCompleteUrlImage(movie.backdropPath))
            detailMovieView.displayTitle(movie.title)
            detailMovieView.displayVoteAverage(movie.voteAverage)
            detailMovieView.displayReleaseDate(formatter.formatDate(movie.releaseDate))
            detailMovieView.displayOverview(movie.overview)
        }
    }

    override fun error() {
        view.get()?.showErrorMessage()
    }

    fun navUpSelected() {
        view.get()?.goToBack()
    }

}