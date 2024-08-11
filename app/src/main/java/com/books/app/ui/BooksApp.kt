package com.books.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.app.R
import com.books.app.navigation.BooksNavHost
import com.books.app.ui.dialog.BooksAlertDialog

@Composable
fun BooksApp(
    appState: BooksAppState,
    modifier: Modifier = Modifier
) {
    val isOffline = appState.isOffline.collectAsStateWithLifecycle().value

    BooksNavHost(
        appState = appState,
        modifier = modifier
    )

    if (isOffline) {
        BooksAlertDialog(
            title = stringResource(R.string.whoops_error_title),
            message = stringResource(R.string.no_internet_error_message_text),
            onDismiss = {
                //some logic
            },
            onConfirm = {
                //some logic
            }
        )
    }
}