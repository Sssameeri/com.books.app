package com.books.app.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.data.BookPageFactory
import com.books.app.data.BooksByGenreFactory
import com.books.app.ui.MainTopBar
import com.books.app.ui.booksByGenre
import com.books.app.ui.pager.BooksPager
import com.books.app.ui.resources.BlackBackground
import com.books.app.ui.resources._16_Dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val listScrollState = rememberLazyListState()
    Scaffold(
        topBar = { MainTopBar() },
        containerColor = BlackBackground
    ) { paddingValues ->
        LazyColumn(
            state = listScrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                //hack to disable overscroll and enable infinity scrolling
                CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
                    BooksPager(
                        items = BookPageFactory.pages,
                        pagerState = rememberPagerState { BookPageFactory.pages.size },
                        onItemClicked = { /*TODO*/ },
                        modifier = Modifier
                            .padding(start = _16_Dp, end = _16_Dp, bottom = _16_Dp)
                    )
                }
            }

            BooksByGenreFactory.booksByGenre.forEach {
                booksByGenre(it) {

                }
            }

            item {
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
            }
        }
    }
}

@Preview
@Composable
fun Preview_MainScreen() {
//    MainScreen()
}