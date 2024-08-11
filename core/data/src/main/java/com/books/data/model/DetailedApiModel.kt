package com.books.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DetailedApiModel(
    val books: List<BookItemApiModel>
)