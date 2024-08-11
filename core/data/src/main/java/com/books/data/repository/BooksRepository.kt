package com.books.data.repository

import com.books.data.model.BannerItemApiModel
import com.books.data.model.BookItemApiModel
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    suspend fun fetchBooksData()
    suspend fun fetchDetailedBooksInfo(): List<BookItemApiModel>

    //like UseCases but without domain layer
    fun observeBannersData(): Flow<List<BannerItemApiModel>>
    fun observeBooksData(): Flow<List<BookItemApiModel>>

    suspend fun getRecommendations(): List<BookItemApiModel>
}