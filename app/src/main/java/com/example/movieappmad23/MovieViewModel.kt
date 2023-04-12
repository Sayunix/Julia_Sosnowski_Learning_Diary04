package com.example.movieappmad23

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies

class MovieViewModel : ViewModel() {

    private val _allMovies: SnapshotStateList<Movie> = mutableStateListOf()
    val allMovies: List<Movie> get() = _allMovies

    init {
        // Load movies into the ViewModel. Replace this with your movie loading method.
        _allMovies.addAll(getMovies())
    }

    fun toggleFavorite(movieId: String) {
        val movie = _allMovies.find { it.id == movieId }
        movie?.isFavorite = movie?.isFavorite?.not() ?: false
    }

    val favoriteMovies: List<Movie>
        get() = _allMovies.filter { it.isFavorite }

}