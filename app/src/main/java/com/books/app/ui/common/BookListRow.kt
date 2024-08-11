package com.books.app.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.books.app.state.Book
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources._01_Sp
import com.books.app.ui.resources._120_Dp
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._16_Sp
import com.books.app.ui.resources._17_Sp
import com.books.app.ui.resources._4_Dp
import com.books.app.ui.resources._8_Dp

@Composable
fun BookListRow(
    books: List<Book>,
    onBookClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White.copy(alpha = 0.7f)
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(_8_Dp)
    ) {
        items(
            items = books,
            key = { it.id }
        ) {
            BookListItem(
                book = it,
                textColor = textColor,
                onBookClick = onBookClick,
                modifier = Modifier
                    .width(_120_Dp)
            )
        }
    }
}

@Composable
private fun BookListItem(
    book: Book,
    textColor: Color,
    onBookClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String = "book item"
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.coverImage)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(0.8f)
                .fillMaxSize()
                .clip(RoundedCornerShape(_16_Dp))
                .clickable { onBookClick(book.id) }
        )

        Text(
            text = book.coverTitle,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            textAlign = TextAlign.Left,
            fontSize = _16_Sp,
            lineHeight = _17_Sp,
            letterSpacing = _01_Sp,
            overflow = TextOverflow.Ellipsis,
            color = textColor,
            modifier = Modifier.padding(top = _4_Dp)
        )
    }
}