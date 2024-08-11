package com.books.app.ui.screen.details

import androidx.annotation.StringRes
import com.books.app.R
import com.books.data.model.BookItemApiModel

data class StatsProperty(
    val data: String,
    val property: PropertyName
) {

    companion object {

        fun listOfFromApiModel(apiModel: BookItemApiModel) = apiModel.run {
            return@run mutableListOf<StatsProperty>().apply {
                add(StatsProperty(likes, PropertyName.LIKES))
                add(StatsProperty(quotes, PropertyName.QUOTES))
                add(StatsProperty(genre, PropertyName.GENRE))
                add(StatsProperty(views, PropertyName.READERS))
            }.toList()
        }


    }

}

enum class PropertyName(@StringRes val res: Int) {
    READERS(R.string.stats_property_reader),
    LIKES(R.string.stats_property_likes),
    QUOTES(R.string.stats_property_quotes),
    GENRE(R.string.stats_property_genre)
}
