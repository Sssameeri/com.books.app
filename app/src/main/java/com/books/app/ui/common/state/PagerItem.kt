package com.books.app.ui.common.state

import com.books.data.model.BannerItemApiModel

data class PagerItem(
    val id: Int,
    val bookId: Int,
    val imageUrl: String
) {

    companion object {

        fun fromApiModel(apiModel: BannerItemApiModel) =
            apiModel.run {
                PagerItem(
                    id = id,
                    imageUrl = cover,
                    bookId = bookId
                )
            }

    }

}
