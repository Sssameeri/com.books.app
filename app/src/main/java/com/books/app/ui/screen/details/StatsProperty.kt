package com.books.app.ui.screen.details

import androidx.annotation.StringRes
import com.books.app.R

data class StatsProperty(
    val data: String,
    val property: PropertyName
)

enum class PropertyName(@StringRes val res : Int) {
    READERS(R.string.stats_property_reader),
    LIKES(R.string.stats_property_likes),
    QUOTES(R.string.stats_property_quotes),
    GENRE(R.string.stats_property_genre)
}
