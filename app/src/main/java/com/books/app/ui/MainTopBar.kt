package com.books.app.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.R
import com.books.app.ui.resources.BlackBackground
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.TopBarTitleColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = BlackBackground
        ),
        title = {
            Text(
                text = stringResource(R.string.toolbar_main_screen_title),
                color = TopBarTitleColor,
                fontFamily = NunitoSans
            )
        }
    )
}

@Preview
@Composable
fun Preview_TopBar() {
    MainTopBar()
}