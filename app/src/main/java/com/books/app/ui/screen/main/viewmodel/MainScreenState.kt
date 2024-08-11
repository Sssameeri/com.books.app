package com.books.app.ui.screen.main.viewmodel

import com.books.app.state.Book
import com.books.app.state.PagerItem
import com.books.data.model.BannerItemApiModel
import com.books.data.model.BookItemApiModel

sealed class MainScreenState {

    data object Loading : MainScreenState()

    data class Loaded(
        val carouselData: List<PagerItem>,
        val booksByGenres: Map<String, List<Book>>
    ) : MainScreenState() {

        companion object {
            fun fromRemoteApiModel(
                books: List<BookItemApiModel>, banners: List<BannerItemApiModel>
            ): MainScreenState = run {
                fun List<BookItemApiModel>.toBooksByGenres() =
                    groupBy { it.genre }.mapValues { it.value.map(Book.Companion::fromApiModel) }

                fun List<BannerItemApiModel>.toCarouselData() =
                    map(PagerItem.Companion::fromApiModel)

                Loaded(
                    carouselData = banners.toCarouselData(),
                    booksByGenres = books.toBooksByGenres()
                )
            }
        }

    }

    data object Error : MainScreenState()

}