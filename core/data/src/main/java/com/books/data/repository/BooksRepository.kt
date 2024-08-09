package com.books.data.repository

import com.books.data.model.RemoteApiModel
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun loadBooksData(): Flow<RemoteApiModel>

}