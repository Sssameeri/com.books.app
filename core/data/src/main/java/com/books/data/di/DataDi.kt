package com.books.data.di

import android.content.Context
import com.books.data.network.ConnectivityManagerNetworkMonitor
import com.books.data.network.NetworkMonitor
import com.books.data.repository.BooksRepository
import com.books.data.repository.RemoteBooksRepository
import com.books.data.source.BooksDataSource
import com.books.data.source.FirebaseBooksDataSource
import com.books.firebase.FirebaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataDi {

    @[Provides Singleton]
    fun providesBooksDataSource(
        firebaseHelper: FirebaseHelper
    ): BooksDataSource = FirebaseBooksDataSource(firebaseHelper)

    @[Provides Singleton]
    fun provideBooksRepository(
        dataSource: BooksDataSource
    ): BooksRepository = RemoteBooksRepository(dataSource)

    @[Provides Singleton]
    fun providesNetworkMonitor(
        @ApplicationContext context: Context,
    ): NetworkMonitor = ConnectivityManagerNetworkMonitor(context)

}