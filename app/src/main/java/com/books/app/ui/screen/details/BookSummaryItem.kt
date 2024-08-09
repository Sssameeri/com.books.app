package com.books.app.ui.screen.details

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.ui.resources.DetailsTitleColor
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.SummaryTextColor
import com.books.app.ui.resources._16_Dp
import com.books.app.ui.resources._8_Dp

@Composable
fun BookSummaryItem(
    summary: String,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .animateContentSize()
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.summary),
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            color = DetailsTitleColor,
            fontSize = 20.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.1.sp,
            modifier = Modifier
                .padding(bottom = _8_Dp)
        )
        Text(
            text = summary,
            color = SummaryTextColor,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            overflow = TextOverflow.Ellipsis,
            maxLines = if (expanded) summary.lines().size else 7,
            modifier = Modifier
                .clickable { expanded = !expanded }
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(top = _16_Dp)
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