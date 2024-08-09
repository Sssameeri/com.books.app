package com.books.app.state

import com.books.app.ui.screen.details.PropertyName
import com.books.app.ui.screen.details.StatsProperty

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