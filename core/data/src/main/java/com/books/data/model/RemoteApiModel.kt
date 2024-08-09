package com.books.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteApiModel(
    val books: List<BookItemApiModel>,
    @SerialName("top_banner_slides")
    val banners: List<BannerItemApiModel>,
    @SerialName("you_will_like_section")
    val recommendations: List<Int>
)
