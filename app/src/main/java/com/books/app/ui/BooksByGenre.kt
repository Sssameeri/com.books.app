package com.books.app.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources._14_Dp
import com.books.app.ui.resources._16_Dp

fun LazyListScope.booksByGenre(
    booksByGenre: Pair<String, List<Book>>,
    onBookClick: () -> Unit,
) {
    item {
        Text(
            text = booksByGenre.first,
            color = Color.White,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = _16_Dp, end = _16_Dp, top = _16_Dp)
        )
    }

    item {
        BookListRow(
            books = booksByGenre.second,
            onBookClick = onBookClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = _14_Dp, start = _16_Dp)
        )
    }
}