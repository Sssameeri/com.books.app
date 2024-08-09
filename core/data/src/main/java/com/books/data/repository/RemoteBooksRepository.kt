package com.books.data.repository

import com.books.data.source.BooksDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteBooksRepository @Inject constructor(
    private val dataSource: BooksDataSource,
) : BooksRepository {

    override fun loadBooksData() =
        flow { emit(dataSource.loadData()) }


}