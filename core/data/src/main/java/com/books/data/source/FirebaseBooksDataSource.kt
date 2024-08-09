package com.books.data.source

import com.books.data.firebase.FirebaseHelper
import com.books.data.model.RemoteApiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

private const val FIREBASE_DATA_KEY = "json_data"

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
                    json.decodeFromString<RemoteApiModel>(it)
                }
            }
        }

}