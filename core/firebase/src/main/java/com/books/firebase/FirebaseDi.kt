package com.books.firebase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object FirebaseDi {

    @[Provides Singleton]
    fun providesFirebaseHelper() = FirebaseHelper()

}