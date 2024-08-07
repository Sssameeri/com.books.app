package com.books.app.ui.pager

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.books.app.ui.BookPage
import com.books.app.ui.theme.PagerItemSelectedColor
import com.books.app.ui.theme.PagerItemUnselectedColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private val animationSpecs = spring<Float>(stiffness = Spring.StiffnessMediumLow)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BooksPager(
    items: List<BookPage>,
    pagerState: PagerState,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    fun scrollToRight() {
        coroutineScope.launch {
            if (pagerState.currentPage == items.lastIndex) {
                pagerState.animateScrollToPage(
                    0,
                    animationSpec = animationSpecs
                )
            } else {
                pagerState.animateScrollToPage(
                    pagerState.currentPage + 1,
                    animationSpec = animationSpecs
                )
            }
        }
    }

    fun scrollToLeft() {
        coroutineScope.launch {
            if (pagerState.currentPage == 0) {
                pagerState.animateScrollToPage(
                    items.lastIndex,
                    animationSpec = animationSpecs
                )
            } else {
                pagerState.animateScrollToPage(
                    pagerState.currentPage - 1,
                    animationSpec = animationSpecs
                )
            }
        }
    }

    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,

        ) { page ->
            val item = items[page]
            BooksPagerItem(
                item = item,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            change.consume()
                            when {
                                dragAmount < 0 -> {
                                    scrollToRight()
                                }
                                dragAmount > 0 -> {
                                    scrollToLeft()
                                }
                            }
                        }
                    },
                onItemClick = onItemClicked
            )
        }
        PagerProgress(
            pageCount = items.size,
            currentPage = pagerState.currentPage
        )
    }
}

@Composable
private fun BoxScope.PagerProgress(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .align(Alignment.BottomCenter)
            .padding(7.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { index ->
            val color =
                if (currentPage == index) PagerItemSelectedColor else PagerItemUnselectedColor
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .size(7.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Composable
private fun BooksPagerItem(
    item: BookPage,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String = "books pager item",
) {
    Card(
        modifier = modifier
            .height(160.dp)
            .fillMaxWidth(),
        onClick = { onItemClick() },
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.imageUrl)
                .build(),
            modifier = Modifier.fillMaxSize(),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview_BooksPagerItem() {
    val books = listOf(
        BookPage(
            1,
            "https://images.unsplash.com/photo-1719937206255-cc337bccfc7d?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        BookPage(
            2,
            "https://images.unsplash.com/photo-1719937206255-cc337bccfc7d?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        BookPage(
            3,
            "https://images.unsplash.com/photo-1722486110900-cfb036cf1830?q=80&w=3174&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        BookPage(
            4,
            "https://images.unsplash.com/photo-1720048170996-40507a45c720?q=80&w=3113&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
    )
    BooksPager(
        items = books,
        onItemClicked = { /*TODO*/ },
        pagerState = rememberPagerState { books.size }
    )
}