package com.books.app.ui.screen.details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.app.R
import com.books.app.ui.app_bar.DetailsTopBar
import com.books.app.ui.dialog.BooksAlertDialog
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._20_Dp
import com.books.app.ui.resources._24_Dp
import com.books.app.ui.resources._48_Dp
import com.books.app.ui.resources._50_Dp
import com.books.app.ui.resources._64_Dp
import com.books.app.ui.screen.details.viewmodel.DetailsScreenViewModel
import com.books.app.ui.screen.details.viewmodel.DetailsUiState.Error
import com.books.app.ui.screen.details.viewmodel.DetailsUiState.Loaded
import com.books.app.ui.screen.details.viewmodel.DetailsUiState.Loading
import com.books.app.ui.screen.main.pager.DetailsBookPager

@Composable
fun DetailsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    when (val state = viewModel.state.collectAsStateWithLifecycle().value) {
        Error -> DetailsScreenError()
        is Loaded -> DetailsScreenLoaded(
            state = state,
            onBookSwiped = viewModel::onBookSwiped,
            onBackClick = onBackClick,
            modifier = modifier
        )
        Loading -> DetailsScreenLoading()
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.bg_details),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    )
}


@Composable
private fun DetailsScreenLoading(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DetailsScreenLoaded(
    state: Loaded,
    onBookSwiped: (Int) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = state.currentBookIndex
    ) {
        state.booksSize
    }

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            onBookSwiped(it)
        }
    }

    LaunchedEffect(key1 = state.currentBook) {
        pagerState.scrollToPage(state.currentBookIndex)
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Header()
        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    DetailsTopBar(onBackClick = onBackClick)
                    DetailsBookPager(
                        books = state.books,
                        pagerState = pagerState,
                        modifier = Modifier.padding(bottom = _16_Dp)
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.White,
                            RoundedCornerShape(topStart = _20_Dp, topEnd = _20_Dp)
                        )
                        .padding(horizontal = _16_Dp)
                ) {
                    BookStatsRow(
                        stats = state.currentBook.stats,
                        modifier = Modifier
                            .padding(top = _20_Dp)
                            .heightIn(min = _64_Dp)
                    )
                    BookSummaryItem(
                        summary = state.currentBook.summary,
                        modifier = Modifier.padding(top = _16_Dp)
                    )
                }
            }

            item {
                BooksAlsoLike(
                    books = state.recommendedBooks,
                    onBookClick = onBookSwiped,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(
                            start = _16_Dp,
                            top = _16_Dp
                        )
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(
                            top = _24_Dp,
                            start = _50_Dp,
                            end = _50_Dp,
                            bottom = _50_Dp
                        )
                ) {
                    ReadNowButton(
                        onClick = {
                            //TODO implement read logic
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(_48_Dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailsScreenError() {
    BooksAlertDialog(
        title = stringResource(R.string.default_error_title),
        message = stringResource(R.string.default_error_message_text),
        onDismiss = {
            //some logic
        },
        onConfirm = {
            //some logic
        }
    )
}