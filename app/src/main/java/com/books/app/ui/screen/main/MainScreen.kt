package com.books.app.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.app.ui.screen.main.viewmodel.MainScreenState.*
import com.books.app.ui.app_bar.MainTopBar
import com.books.app.ui.screen.main.pager.BooksPager
import com.books.app.ui.resources.BlackBackground
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.screen.main.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    onBookClicked: (Int) -> Unit,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.loadData()
    }
    when (val state = viewModel.state.collectAsStateWithLifecycle().value) {
        is Loaded -> MainScreenLoaded(state, onBookClicked)
        Error -> {

        }
        Loading -> {

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MainScreenLoaded(
    state: Loaded,
    onBookClicked: (Int) -> Unit
) {
    Scaffold(
        topBar = { MainTopBar() },
        containerColor = BlackBackground
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                //hack to disable overscroll and enable "infinity" scrolling
                CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
                    BooksPager(
                        items = state.carouselData,
                        pagerState = rememberPagerState { state.carouselData.size },
                        onItemClicked = onBookClicked,
                        modifier = Modifier
                            .padding(start = _16_Dp, end = _16_Dp, bottom = _16_Dp)
                    )
                }
            }

            state.booksByGenres.forEach { (key, value) ->
                booksByGenre(key, value, onBookClicked)
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