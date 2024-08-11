package com.books.app.ui.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.ReadNowButtonColor
import com.books.app.ui.resources._30_Dp

@Composable
fun RoundedButton(
    cta: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(_30_Dp),
        colors = ButtonDefaults.buttonColors().copy(containerColor = color)
    ) {
        Text(
            text = cta,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            lineHeight = 16.sp
        )
    }
}

@Preview
@Composable
private fun Preview_Button() {
    RoundedButton(cta = "Read now", color = ReadNowButtonColor, onClick = { /*TODO*/ })
}