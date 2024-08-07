package com.books.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.StatsDataColor
import com.books.app.ui.resources.StatsDescriptionColor

@Composable
fun BookStatsRow(
    stats: List<StatsProperty>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        stats.forEach {
            BookStatsItem(statsProperty = it)
        }
    }

    HorizontalDivider()
}

@Composable
private fun BookStatsItem(
    statsProperty: StatsProperty,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = statsProperty.data,
            color = StatsDataColor,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.sp,
            fontSize = 18.sp,
            letterSpacing = 0.1.sp
        )
        Text(
            text = stringResource(id = statsProperty.property.res),
            color = StatsDescriptionColor,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 13.sp,
            fontSize = 12.sp,
            letterSpacing = 0.1.sp
        )
    }
}

@Preview
@Composable
private fun Preview_BookStatsItem() {
    BookStatsItem(
        StatsProperty(
            data = "22.2k",
            property = PropertyName.READERS,
        )
    )
}