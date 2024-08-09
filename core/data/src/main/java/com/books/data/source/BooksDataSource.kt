package com.books.data.source

import com.books.data.model.RemoteApiModel

interface BooksDataSource {

    suspend fun loadData(): RemoteApiModel

}