package com.books.app.ui.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.state.Book
import com.books.app.ui.common.BookListRow
import com.books.app.ui.resources.AlsoLikeBookCoverTitleColor
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources._16_Dp

@Composable
fun BooksAlsoLike(
    books: List<Book>,
    onBookClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.you_will_also_like_title),
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.1.sp,
            modifier = Modifier
                .padding(bottom = _16_Dp)
        )

        BookListRow(
            books = books,
            onBookClick = onBookClick,
            textColor = AlsoLikeBookCoverTitleColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}