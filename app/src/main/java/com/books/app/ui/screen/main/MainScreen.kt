package com.books.app.ui.screen.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.app.R
import com.books.app.ui.app_bar.MainTopBar
import com.books.app.ui.dialog.BooksAlertDialog
import com.books.app.ui.resources.BlackBackground
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.screen.main.pager.BooksPager
import com.books.app.ui.screen.main.viewmodel.MainScreenState.Error
import com.books.app.ui.screen.main.viewmodel.MainScreenState.Loaded
import com.books.app.ui.screen.main.viewmodel.MainScreenState.Loading
import com.books.app.ui.screen.main.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    onBackPressed: () -> Unit,
    onBookClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    when (val state = viewModel.state.collectAsStateWithLifecycle().value) {
        is Loaded -> MainScreenLoaded(state, onBackPressed, onBookClicked, modifier)
        Error -> MainScreenError()
        Loading -> MainScreenLoading()
    }
}

@Composable
private fun MainScreenLoading() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun MainScreenError() {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MainScreenLoaded(
    state: Loaded,
    onBackPressed: () -> Unit,
    onBookClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(enabled = true) {
        onBackPressed()
    }

    Scaffold(
        topBar = { MainTopBar() },
        containerColor = BlackBackground,
        modifier = modifier
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