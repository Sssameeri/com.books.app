package com.books.app.ui.screen.details

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.R
import com.books.app.ui.resources.DetailsTitleColor
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.SummaryTextColor
import com.books.app.ui.resources._01_Sp
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._20_Sp
import com.books.app.ui.resources._22_Sp
import com.books.app.ui.resources._8_Dp

@Composable
fun BookSummaryItem(
    summary: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Text(
            text = stringResource(R.string.summary),
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            color = DetailsTitleColor,
            fontSize = _20_Sp,
            lineHeight = _22_Sp,
            letterSpacing = _01_Sp,
            modifier = Modifier.padding(bottom = _8_Dp)
        )

        Text(
            text = summary,
            color = SummaryTextColor,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            overflow = TextOverflow.Ellipsis
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = _16_Dp)
        )
    }
}


@Preview
@Composable
private fun Preview_SummaryItem() {
    BookSummaryItem(
        """
            According to researchers at Duke University, habits 
            account for about 40 percent of our behaviors on
            any given day. Your life today is essentially the sum 
            of your habits. How in shape or out of shape 
            you are? A result of your habits. How happy or unhappy 
            you are? A result of your habits. How successful 
            or unsuccessful you are? A result of your habits.
            or unsuccessful you are? A result of your habits.
            or unsuccessful you are? A result of your habits.
            or unsuccessful you are? A result of your habits.
        """.trimIndent()
    )
}