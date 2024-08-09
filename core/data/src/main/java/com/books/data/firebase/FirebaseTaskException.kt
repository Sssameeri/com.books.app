package com.books.data.firebase

data class FirebaseTaskException(val info: String) :
    RuntimeException("Firebase task is failed: $info")