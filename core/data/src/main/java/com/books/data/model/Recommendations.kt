package com.books.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recommendations(
    @SerialName("you_will_like_section")
    val ids: List<Int>
)
