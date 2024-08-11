package com.books.app.ui.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.books.app.R
import com.books.app.state.Book
import com.books.app.ui.common.BookListRow
import com.books.app.ui.resources.AlsoLikeBookCoverTitleColor
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources._01_Sp
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._20_Sp
import com.books.app.ui.resources._22_Sp

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
            fontSize = _20_Sp,
            lineHeight = _22_Sp,
            letterSpacing = _01_Sp,
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