package com.books.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainApiModel(
    val books: List<BookItemApiModel>,
    @SerialName("top_banner_slides")
    val banners: List<BannerItemApiModel>,
    @SerialName("you_will_like_section")
    val recommendations: List<Int>
) {

    val bookIds: List<Int>
        get() = books.map { it.id }

    val recommendedBookIds: List<Int>
        get() = books.map { it.id }

    fun bookById(id: Int) =
        books.find { it.id == id } ?: throw IllegalStateException("Can't find book with $id")

}
