package com.books.app.ui.screen.details.viewmodel

import com.books.app.ui.common.state.Book
import com.books.data.model.BookItemApiModel

sealed class DetailsUiState {

    data object Error : DetailsUiState()
    data object Loading : DetailsUiState()

    data class Loaded(
        val books: List<Book>,
        val bookId: Int,
        val recommendedBooks: List<Book> = emptyList()
    ) : DetailsUiState() {

        val currentBook: Book
            get() = books.find { it.id == bookId }
                ?: throw IllegalStateException("Can't find book with id = $bookId")

        val currentBookIndex: Int
            get() = books.indexOf(currentBook)

        val booksSize: Int
            get() = books.size

        companion object {

            fun fromApiModel(
                bookId: Int,
                books: List<BookItemApiModel>,
                recommendedBooks: List<BookItemApiModel>
            ): DetailsUiState = Loaded(
                books = Book.listOfFromApiModel(books),
                bookId = bookId,
                recommendedBooks = Book.listOfFromApiModel(recommendedBooks),
            )

        }

    }

}