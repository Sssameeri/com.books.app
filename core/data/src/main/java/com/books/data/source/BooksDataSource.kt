package com.books.data.source

import com.books.data.model.DetailedApiModel
import com.books.data.model.MainApiModel

interface BooksDataSource {

    suspend fun loadData(): MainApiModel

    suspend fun loadDetailedData(): DetailedApiModel

}