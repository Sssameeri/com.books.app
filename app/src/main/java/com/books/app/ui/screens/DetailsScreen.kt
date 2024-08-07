package com.books.app.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.R
import com.books.app.data.BooksFactory.books
import com.books.app.data.StatsFactory
import com.books.app.ui.BookStatsRow
import com.books.app.ui.BookSummaryItem
import com.books.app.ui.BooksAlsoLike
import com.books.app.ui.Button
import com.books.app.ui.DetailsTopBar
import com.books.app.ui.pager.DetailsBookPager
import com.books.app.ui.resources.ReadNowButtonColor
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._18_Dp
import com.books.app.ui.resources._20_Dp
import com.books.app.ui.resources._24_Dp
import com.books.app.ui.resources._48_Dp
import com.books.app.ui.resources._50_Dp
import com.books.app.ui.resources._64_Dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailsScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Header()
        LazyColumn {
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    DetailsTopBar(onBackClick = { /*TODO*/ })
                    DetailsBookPager(
                        books = books,
                        pagerState = rememberPagerState {
                            books.size
                        }
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = _18_Dp)
                        .background(
                            Color.White,
                            RoundedCornerShape(topStart = _20_Dp, topEnd = _20_Dp)
                        )
                        .padding(horizontal = _16_Dp)
                ) {
                    BookStatsRow(
                        stats = StatsFactory.stats,
                        modifier = Modifier.height(_64_Dp)
                    )
                    BookSummaryItem(
                        summary = books[0].summary,
                        modifier = Modifier.padding(top = _16_Dp)
                    )
                }
            }

            item {
                BooksAlsoLike(
                    books = books,
                    onBookClick = { /*TODO*/ },
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
                        .padding(top = _24_Dp, start = _50_Dp, end = _50_Dp, bottom = _50_Dp)
                ) {
                    Button(
                        cta = stringResource(R.string.read_now_button_cta),
                        color = ReadNowButtonColor,
                        onClick = { /*TODO*/ },
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
private fun Header(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.bg_details),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.TopCenter,
        modifier = modifier
            .fillMaxSize()
    )
}

@Preview
@Composable
private fun Preview_DetailsScreen() {
    DetailsScreen()
}