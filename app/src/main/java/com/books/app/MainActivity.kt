package com.books.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.app.navigation.BooksNavHost
import com.books.app.state.MainScreenState
import com.books.app.state.MainScreenState.*
import com.books.app.ui.rememberBooksAppState
import com.books.app.ui.screen.main.MainScreen
import com.books.app.viewmodel.MainScreenViewModel
import com.books.data.network.NetworkMonitor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.Error

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberBooksAppState(networkMonitor = networkMonitor)
            val isOffline = appState.isOffline.collectAsStateWithLifecycle().value

            if (isOffline) {
                //show offline dialog
            } else {
                BooksNavHost(appState = appState)
            }
        }
    }

}