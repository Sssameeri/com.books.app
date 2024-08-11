package com.books.data.repository

import com.books.data.model.BannerItemApiModel
import com.books.data.model.BookItemApiModel
import com.books.data.source.BooksDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteBooksRepository @Inject constructor(
    private val dataSource: BooksDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BooksRepository {

    private val cachedBooks = MutableStateFlow<List<BookItemApiModel>>(emptyList())
    private val cachedBanners = MutableStateFlow<List<BannerItemApiModel>>(emptyList())
    private val cachedRecommendations = MutableStateFlow<List<BookItemApiModel>>(emptyList())

    override suspend fun fetchBooksData() =
        coroutineScope {
            withContext(ioDispatcher) {
                dataSource.loadData().run {
                    cachedBooks.update { books }
                    cachedBanners.update { banners }
                    cachedRecommendations.update { books.filter { it.id in recommendations } }
                }
            }
        }

    override suspend fun fetchDetailedBooksInfo() =
        coroutineScope {
            withContext(ioDispatcher) {
                dataSource.loadDetailedData().books
            }
        }

    override fun observeBannersData() =
        cachedBanners.asStateFlow()

    override fun observeBooksData() =
        cachedBooks.asStateFlow()

    override suspend fun getRecommendations() =
        cachedRecommendations.value

}