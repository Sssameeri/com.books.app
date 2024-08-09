package com.books.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BooksApiModel(
    val books: List<BookItemApiModel>
)
