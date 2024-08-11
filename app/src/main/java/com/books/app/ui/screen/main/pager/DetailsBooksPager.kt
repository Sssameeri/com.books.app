package com.books.app.ui.screen.main.pager

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.books.app.ui.common.state.Book
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources._14_Sp
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._16_Sp
import com.books.app.ui.resources._200_Dp
import com.books.app.ui.resources._20_Sp
import com.books.app.ui.resources._22_Sp
import com.books.app.ui.resources._4_Dp
import kotlin.math.absoluteValue

private val IMAGE_SIZE_DP = _200_Dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailsBookPager(
    books: List<Book>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        val horizontalPadding = (this.maxWidth - IMAGE_SIZE_DP) / 2
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(
                horizontal = horizontalPadding
            ),
            pageSize = PageSize.Fixed(IMAGE_SIZE_DP),
            key = { books[it].id },
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val book = books[page]
            BookPagerItem(
                book = book,
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                                .absoluteValue
                        val scale = lerp(
                            0.8f,
                            1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                        scaleY = scale
                        scaleX = scale
                    }
            )
        }
    }

}

@Composable
private fun BookPagerItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.coverImage)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = "Book name: ${book.coverTitle}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(IMAGE_SIZE_DP, 250.dp)
                .clip(RoundedCornerShape(_16_Dp))
        )

        Text(
            text = book.coverTitle,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            lineHeight = _22_Sp,
            fontSize = _20_Sp,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.padding(top = _16_Dp)
        )

        Text(
            text = book.author,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = _14_Sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            lineHeight = _16_Sp,
            modifier = Modifier.padding(top = _4_Dp)
        )
    }
}