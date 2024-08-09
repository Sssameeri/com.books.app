package com.books.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.state.MainScreenState
import com.books.app.state.MainScreenState.Error
import com.books.app.state.MainScreenState.Loaded.Companion.fromRemoteApiModel
import com.books.app.state.MainScreenState.Loading
import com.books.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: BooksRepository
) : ViewModel() {

    val state: StateFlow<MainScreenState> = repository
        .loadBooksData()
        .map { fromRemoteApiModel(it) }
        .catch {
            Log.d("TAGGGR", "catch: $it")
            emit(Error)
        }
        .stateIn(
            viewModelScope,
            WhileSubscribed(5000),
            Loading,
        )


}