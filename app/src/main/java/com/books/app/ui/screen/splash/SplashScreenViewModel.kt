package com.books.app.ui.screen.splash

import androidx.lifecycle.ViewModel
import com.books.app.ui.screen.splash.SplashScreenViewModel.SplashUiState.Error
import com.books.app.ui.screen.splash.SplashScreenViewModel.SplashUiState.Loaded
import com.books.app.ui.screen.splash.SplashScreenViewModel.SplashUiState.Loading
import com.books.common.di.ApplicationScope
import com.books.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val repository: BooksRepository,
    @ApplicationScope private val coroutineScope: CoroutineScope
) : ViewModel() {

    private val _state = MutableStateFlow<SplashUiState>(Loading)
    val state: StateFlow<SplashUiState> = _state.asStateFlow()

    init {
        coroutineScope.launch {
            try {
                delay(2.seconds)
                _state.update { Loaded }
                repository.fetchBooksData()
            } catch (t: Throwable) {
                _state.update { Error }
            }
        }
    }

    sealed class SplashUiState {
        data object Loading : SplashUiState()
        data object Loaded : SplashUiState()
        data object Error : SplashUiState()
    }

}