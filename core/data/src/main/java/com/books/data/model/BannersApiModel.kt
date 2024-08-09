package com.books.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannersApiModel(
    @SerialName("top_banner_slides")
    val banners: List<BannerItemApiModel>
)
