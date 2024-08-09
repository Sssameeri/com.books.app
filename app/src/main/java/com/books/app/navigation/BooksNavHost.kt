package com.books.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.books.app.ui.BooksAppState
import com.books.app.ui.screen.details.DetailsScreen
import com.books.app.ui.screen.main.MainScreen

@Composable
fun BooksNavHost(
    appState: BooksAppState,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = appState.navController,
        startDestination = BooksAppNavigation.Main.route,
        modifier = modifier
    ) {
        composable(BooksAppNavigation.Main.route) {
            MainScreen(
                onBookClicked = { id -> appState.navigateDetailsScreen(id) }
            )
        }
        composable(BooksAppNavigation.Details.route) {
            DetailsScreen(
                onBackClick = { appState.navigateBack() }
            )
        }
    }
}

sealed class BooksAppNavigation(val route: String) {
    data object Main : BooksAppNavigation("Main")
    data object Details : BooksAppNavigation("Details")
}