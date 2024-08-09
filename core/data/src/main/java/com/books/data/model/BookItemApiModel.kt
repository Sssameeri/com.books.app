package com.books.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookItemApiModel(
    val id: Int,
    val name: String,
    val author: String,
    val summary: String,
    val genre: String,
    @SerialName("cover_url")
    val coverUrl: String,
    val views: String,
    val likes: String,
    val quotes: String
)
