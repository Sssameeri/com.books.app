package com.books.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        composable(
            BooksAppNavigation.Details.route,
            arguments = listOf(navArgument(ARG_BOOK_ID_KEY) { type = NavType.StringType })
        ) {
            DetailsScreen(
                onBackClick = { appState.navigateBack() }
            )
        }
    }
}

const val ARG_BOOK_ID_KEY = "bookId"

sealed class BooksAppNavigation(val route: String) {
    data object Main : BooksAppNavigation("main")
    data object Details : BooksAppNavigation("details/{$ARG_BOOK_ID_KEY}") {
        fun createRoute(bookId: Int) = "details/$bookId"
    }
}