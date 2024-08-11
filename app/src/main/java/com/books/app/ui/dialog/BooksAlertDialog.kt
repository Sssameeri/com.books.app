package com.books.app.ui.dialog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.ui.common.RoundedButton
import com.books.app.ui.resources.BlackBackground
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.ReadNowButtonColor
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._16_Sp

@Composable
fun BooksAlertDialog(
    title: String,
    message: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            RoundedButton(
                cta = stringResource(id = android.R.string.ok),
                color = ReadNowButtonColor,
                onClick = onConfirm
            )
        },
        shape = RoundedCornerShape(_16_Dp),
        title = {
            Text(
                text = title,
                fontFamily = NunitoSans,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                lineHeight = _16_Sp,
                textAlign = TextAlign.Center
            )
        },
        text = {
            Text(
                text = message,
                fontFamily = NunitoSans,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                maxLines = 2,
                textAlign = TextAlign.Center
            )
        },
        containerColor = BlackBackground,
        modifier = modifier
    )
}

@Preview
@Composable
private fun Preview_BooksAlertDialog() {
    BooksAlertDialog(
        title = "Error",
        message = "No network connection",
        onDismiss = { },
        onConfirm = { })
}