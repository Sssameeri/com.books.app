package com.books.data.source

import com.books.data.firebase.FirebaseHelper
import com.books.data.model.DetailedApiModel
import com.books.data.model.MainApiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.tasks.asTask
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

private const val FIREBASE_DATA_KEY = "json_data"
private const val FIREBASE_DETAILED_DATA_KEY = "details_carousel"

class FirebaseBooksDataSource(
    private val firebaseHelper: FirebaseHelper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BooksDataSource {

    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    override suspend fun loadData() =
        coroutineScope {
            withContext(dispatcher) {
                firebaseHelper.fetchAndActivateValues().asDeferred().await()
                firebaseHelper.getValueAsString(FIREBASE_DATA_KEY).let {
                    json.decodeFromString<MainApiModel>(it)
                }
            }
        }

    override suspend fun loadDetailedData() =
        coroutineScope {
            withContext(dispatcher) {
                firebaseHelper.fetchAndActivateValues().asDeferred().await()
                firebaseHelper.getValueAsString(FIREBASE_DETAILED_DATA_KEY).let {
                    json.decodeFromString<DetailedApiModel>(it)
                }
            }
        }

}