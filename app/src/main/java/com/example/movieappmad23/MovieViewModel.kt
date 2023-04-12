package com.example.movieappmad23

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies

class MovieViewModel : ViewModel() {
    private val _movies = mutableStateOf(emptyList<Movie>())
    val movies: List<Movie> get() = _movies.value

    fun toggleFavorite(movieId: String) {
        _movies.value = _movies.value.map { movie ->
            if (movie.id == movieId) {
                movie.copy(isFavorite = !movie.isFavorite)
            } else {
                movie
            }
        }
    }
    fun addMovie(movie: Movie) {
        val currentMovies = _movies.value?.toMutableList() ?: mutableListOf()
        currentMovies.add(movie)
        _movies.value = currentMovies
    }
    val favoriteMovies: List<Movie>
        get() = _movies.value?.filter { it.isFavorite } ?: listOf()

    fun getFavorites(): List<Movie> {
        return _movies.value.filter { it.favorite.value }
    }
}