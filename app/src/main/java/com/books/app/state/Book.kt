package com.books.app.state

import com.books.app.ui.screen.details.StatsProperty
import com.books.data.model.BookItemApiModel

data class Book(
    val id: Int,
    val coverTitle: String,
    val coverImage: String,
    val author: String,
    val summary: String,
    val stats: List<StatsProperty>
) {

    companion object {

        fun fromApiModel(apiModel: BookItemApiModel) = apiModel.run {
            Book(
                id = id,
                coverImage = coverUrl,
                coverTitle = name,
                author = author,
                summary = summary,
                stats = StatsProperty.listOfFromApiModel(this)
            )
        }

        fun listOfFromApiModel(books : List<BookItemApiModel> ) =
            books.map { fromApiModel(it) }

    }

}