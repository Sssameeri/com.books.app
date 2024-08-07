package com.books.app.data

import com.books.app.ui.PropertyName
import com.books.app.ui.StatsProperty

object StatsFactory {
    val stats = listOf(
        StatsProperty(
            data = "22.2k",
            property = PropertyName.READERS
        ),
        StatsProperty(
            data = "10.4k",
            property = PropertyName.LIKES
        ),
        StatsProperty(
            data = "32.5k",
            property = PropertyName.QUOTES
        ),
        StatsProperty(
            data = "Hot",
            property = PropertyName.GENRE
        ),
    )
}