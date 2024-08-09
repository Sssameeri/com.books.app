package com.books.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerItemApiModel(
    val id: Int,
    @SerialName("book_id")
    val bookId: Int,
    val cover: String
)
