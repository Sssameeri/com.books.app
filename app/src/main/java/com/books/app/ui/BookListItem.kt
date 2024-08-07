package com.books.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.books.app.ui.theme.NunitoSans

@Composable
fun BookListRow(
    books: List<Book>,
    onBookClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = books,
            key = { it.id }
        ) {
            BookListItem(
                book = it,
                modifier = Modifier
                    .width(120.dp)
                    .clickable { onBookClick() }
            )
        }
    }
}

@Composable
private fun BookListItem(
    book: Book,
    modifier: Modifier = Modifier,
    contentDescription: String = "book item"
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.coverImage)
                .build(),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(0.8f)
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        )

        Text(
            text = book.coverTitle,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            textAlign = TextAlign.Left,
            fontSize = 16.sp,
            lineHeight = 17.sp,
            letterSpacing = 0.1.sp,
            overflow = TextOverflow.Ellipsis,
            color = Color.White.copy(alpha = 0.7f)
        )
    }
}

@Preview(
    backgroundColor = 0xff000000,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun Preview_BookListItem() {
    BookListItem(
        Book(
            0,
            "Kotlin in Action and some very interesting information",
            "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
        ),
        modifier = Modifier
            .width(120.dp)
    )
}

@Preview(
    backgroundColor = 0xff000000,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun Preview_BookListRow() {
    BookListRow(
        books = listOf(
            Book(
                0,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            ),
            Book(
                1,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            ),
            Book(
                2,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            ),
            Book(
                3,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            ),
            Book(
                4,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            ),
            Book(
                5,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            ),
            Book(
                6,
                "Kotlin in Action and some very interesting information",
                "https://images.manning.com/360/480/resize/book/d/10703bb-89a5-411a-84fe-d2a6c74c46e4/Isakova-2ed-HI.png",
            )
        ),
        onBookClick = { /*TODO*/ }
    )
}