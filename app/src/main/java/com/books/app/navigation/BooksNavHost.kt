package com.books.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.books.app.navigation.BooksAppNavigation.*
import com.books.app.ui.BooksAppState
import com.books.app.ui.screen.details.DetailsScreen
import com.books.app.ui.screen.main.MainScreen
import com.books.app.ui.screen.splash.SplashScreen

@Composable
fun BooksNavHost(
    appState: BooksAppState,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = appState.navController,
        startDestination = Splash.route,
        modifier = modifier
    ) {
        composable(Splash.route) {
            SplashScreen(
                onAppReady = appState::navigateMainScreen,
                onConfirmAlertDialog = appState::finishActivity
            )
        }
        composable(Main.route) {
            MainScreen(
                onBackPressed = appState::finishActivity,
                onBookClicked = appState::navigateDetailsScreen
            )
        }
        composable(
            Details.route,
            arguments = listOf(navArgument(ARG_BOOK_ID_KEY) { type = NavType.StringType })
        ) {
            DetailsScreen(
                onBackClick = appState::navigateBack
            )
        }
    }
}

const val ARG_BOOK_ID_KEY = "bookId"

sealed class BooksAppNavigation(val route: String) {
    data object Splash : BooksAppNavigation("splash")
    data object Main : BooksAppNavigation("main")
    data object Details : BooksAppNavigation("details/{$ARG_BOOK_ID_KEY}") {
        fun createRoute(bookId: Int) = "details/$bookId"
    }
}