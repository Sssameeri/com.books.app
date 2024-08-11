package com.books.app.ui.screen.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.navigation.ARG_BOOK_ID_KEY
import com.books.app.ui.screen.details.viewmodel.DetailsUiState.Error
import com.books.app.ui.screen.details.viewmodel.DetailsUiState.Loaded
import com.books.app.ui.screen.details.viewmodel.DetailsUiState.Loading
import com.books.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val bookId: Int =
        savedStateHandle.get<String>(ARG_BOOK_ID_KEY)!!.toInt()

    private val _state = MutableStateFlow<DetailsUiState>(Loading)
    val state: StateFlow<DetailsUiState> = _state.asStateFlow()

    init {
        fetchDetailedData()
    }

    private fun fetchDetailedData() {
        viewModelScope.launch {
            try {
                val books = booksRepository.fetchDetailedBooksInfo()
                _state.update {
                    Loaded.fromApiModel(
                        bookId = bookId,
                        books = books,
                        recommendedBooks = booksRepository.getRecommendations()
                    )
                }
            } catch (e: Exception) {
                _state.update { Error }
            }
        }
    }

    fun onBookSwiped(bookId: Int) {
        _state.update {
            (it as? Loaded)?.copy(bookId = bookId) ?: return
        }
    }


}