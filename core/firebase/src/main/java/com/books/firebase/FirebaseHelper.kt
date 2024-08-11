package com.books.firebase

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.tasks.asDeferred

class FirebaseHelper {

    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 3600
    }

    private val firebaseRemoteConfig: FirebaseRemoteConfig =
        Firebase.remoteConfig

    init {
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun fetchAndActivateValues() =
        firebaseRemoteConfig.fetchAndActivate().asDeferred()

    fun getValueAsString(key: String) =
        firebaseRemoteConfig.getValue(key).asString()

}

