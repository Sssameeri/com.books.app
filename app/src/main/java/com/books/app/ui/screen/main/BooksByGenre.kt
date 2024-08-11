package com.books.app.ui.screen.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.books.app.state.Book
import com.books.app.ui.common.BookListRow
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources._14_Dp
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._20_Sp

fun LazyListScope.booksByGenre(
    genre: String,
    books: List<Book>,
    onBookClick: (Int) -> Unit,
) {
    item {
        Text(
            text = genre,
            color = Color.White,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            fontSize = _20_Sp,
            modifier = Modifier.padding(start = _16_Dp, end = _16_Dp, top = _16_Dp)
        )
    }

    item {
        BookListRow(
            books = books,
            onBookClick = onBookClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = _14_Dp, start = _16_Dp)
        )
    }
}