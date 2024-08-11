package com.books.app.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.books.app.MainActivity
import com.books.app.navigation.BooksAppNavigation
import com.books.data.network.NetworkMonitor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


@Composable
fun rememberBooksAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
): BooksAppState {
    return remember { BooksAppState(navController, networkMonitor, coroutineScope, context) }
}

@Stable
class BooksAppState(
    val navController: NavHostController,
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope,
    private val context: Context
) {

    val isOffline = networkMonitor.isOnline
        .map { !it }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun navigateDetailsScreen(bookId: Int) {
        navController.navigate(BooksAppNavigation.Details.createRoute(bookId))
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    fun finishActivity() {
        (context as? MainActivity)?.finish()
    }

    fun navigateMainScreen() {
        navController.navigate(BooksAppNavigation.Main.route)
    }

}