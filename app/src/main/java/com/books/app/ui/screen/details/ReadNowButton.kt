package com.books.app.ui.screen.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.R
import com.books.app.ui.common.RoundedButton
import com.books.app.ui.resources.ReadNowButtonColor

@Composable
fun ReadNowButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    RoundedButton(
        cta = stringResource(R.string.read_now_button_cta),
        color = ReadNowButtonColor,
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun Preview_Button() {
    RoundedButton(cta = "Read now", color = ReadNowButtonColor, onClick = { /*TODO*/ })
}