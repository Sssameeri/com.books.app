package com.books.app.ui.screen.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.ui.screen.main.viewmodel.MainScreenState.Error
import com.books.app.ui.screen.main.viewmodel.MainScreenState.Loaded.Companion.fromRemoteApiModel
import com.books.app.ui.screen.main.viewmodel.MainScreenState.Loading
import com.books.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: BooksRepository
) : ViewModel() {

    fun loadData() {
        viewModelScope.launch {
            repository.fetchBooksData()
        }
    }

    val state: StateFlow<MainScreenState> = repository
        .observeBooksData()
        .combine(repository.observeBannersData()) { books, banners ->
            fromRemoteApiModel(books, banners)
        }
        .catch { emit(Error) }
        .stateIn(
            viewModelScope,
            WhileSubscribed(5000),
            Loading,
        )


}