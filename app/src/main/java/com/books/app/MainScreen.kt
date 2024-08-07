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
        TopBar()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                //hack to disable overscroll and enable infinity scrolling
                CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
                    BooksPager(
                        items = books,
                        pagerState = rememberPagerState { books.size },
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