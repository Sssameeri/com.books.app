package com.books.app.ui.screen.main.pager

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.books.app.state.PagerItem
import com.books.app.ui.resources.PagerItemSelectedColor
import com.books.app.ui.resources.PagerItemUnselectedColor
import com.books.app.ui.resources._160_Dp
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._5_Dp
import com.books.app.ui.resources._7_Dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

private val animationSpecs =
    spring<Float>(stiffness = Spring.StiffnessMediumLow)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BooksPager(
    items: List<PagerItem>,
    pagerState: PagerState,
    onItemClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    fun scrollToRight() {
        coroutineScope.launch {
            pagerState.animateScrollToPage(
                if (pagerState.currentPage == items.lastIndex) 0 else pagerState.currentPage + 1,
                animationSpec = animationSpecs
            )
        }
    }

    fun scrollToLeft() {
        coroutineScope.launch {
            pagerState.animateScrollToPage(
                if (pagerState.currentPage == 0) items.lastIndex else pagerState.currentPage - 1,
                animationSpec = animationSpecs
            )
        }
    }

    LaunchedEffect(key1 = pagerState.settledPage) {
        launch {
            delay(3.seconds)
            with(pagerState) {
                val target = if (currentPage < pageCount - 1) currentPage + 1 else 0
                animateScrollToPage(
                    page = target,
                    animationSpec = animationSpecs
                )
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(_16_Dp))
    ) {
        HorizontalPager(state = pagerState) { page ->
            val item = items[page]
            BooksPagerItem(
                item = item,
                modifier = Modifier
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
            .padding(_7_Dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { index ->
            val color =
                if (currentPage == index) PagerItemSelectedColor else PagerItemUnselectedColor
            Box(
                modifier = Modifier
                    .padding(horizontal = _5_Dp)
                    .size(_7_Dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Composable
private fun BooksPagerItem(
    item: PagerItem,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String = "books pager item",
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.imageUrl)
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build(),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .height(_160_Dp)
            .clickable { onItemClick(item.bookId) }
    )
}