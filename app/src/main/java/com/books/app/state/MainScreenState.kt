package com.books.app.state

import com.books.data.model.BannerItemApiModel
import com.books.data.model.BookItemApiModel
import com.books.data.model.RemoteApiModel

sealed class MainScreenState {

    data object Loading : MainScreenState()

    data class Loaded(
        val carouselData: List<PagerItem>,
        val booksByGenres: Map<String, List<Book>>
    ) : MainScreenState() {

        companion object {
            fun fromRemoteApiModel(apiModel: RemoteApiModel): MainScreenState =
                apiModel.run {
                    fun List<BookItemApiModel>.toBooksByGenres() =
                        groupBy { it.genre }
                            .mapValues {
                                it.value.map { book ->
                                    Book(
                                        id = book.id,
                                        coverImage = book.coverUrl,
                                        coverTitle = book.name,
                                        author = book.author
                                    )
                                }
                            }

                    fun List<BannerItemApiModel>.toCarouselData() =
                        map { PagerItem(it.id, it.bookId, it.cover) }

                    Loaded(
                        carouselData = banners.toCarouselData(),
                        booksByGenres = books.toBooksByGenres()
                    )
                }
        }

    }

    data object Error : MainScreenState()

}