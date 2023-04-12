package com.example.movieappmad23.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad23.screens.*
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieappmad23.MovieViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val movieViewModel = viewModel<MovieViewModel>()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            HomeScreen(navController = navController, viewModel = movieViewModel)
        }

        composable(Screen.FavoriteScreen.route) {
            FavoriteScreen(navController = navController, viewModel = movieViewModel)
        }
        composable(Screen.AddMovieScreen.route) {
            AddMovieScreen(navController = navController, viewModel = movieViewModel)
        }

        // build a route like: root/detail-screen/id=34
        composable(
            Screen.DetailScreen.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {type = NavType.StringType})
        ) { backStackEntry ->    // backstack contains all information from navhost
            DetailScreen(navController = navController, backStackEntry.arguments?.getString(
                DETAIL_ARGUMENT_KEY))   // get the argument from navhost that will be passed
        }
    }
}
