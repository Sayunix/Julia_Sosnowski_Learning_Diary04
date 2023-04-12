package com.example.movieappmad23

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies

class MoviesViewModel : ViewModel() {
    private val _movies = mutableStateOf(movies)
    val movies: List<Movie> get() = _movies.value

    fun toggleFavorite(id: String) {
        _movies.value.find { it.id == id }?.let { movie ->
            movie.favorite.value = !movie.favorite.value
        }
    }

    fun getFavorites(): List<Movie> {
        return _movies.value.filter { it.favorite.value }
    }
}