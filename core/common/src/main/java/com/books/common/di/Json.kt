package com.books.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object JsonDi {

    @[Provides Singleton]
    fun providesJson(): Json =
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }

}