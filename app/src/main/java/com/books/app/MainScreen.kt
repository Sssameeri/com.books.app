package com.books.app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.data.BookPageFactory
import com.books.app.ui.BookPage
import com.books.app.ui.TopBar
import com.books.app.ui.pager.BooksPager
import com.books.app.ui.theme.BlackBackground

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground)
    ) {
        TopBar()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                //hack to disable overscroll and enable infinity scrolling
                CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
                    BooksPager(
                        items = BookPageFactory.pages,
                        pagerState = rememberPagerState { BookPageFactory.pages.size },
                        onItemClicked = { /*TODO*/ }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_MainScreen() {
//    MainScreen()
}