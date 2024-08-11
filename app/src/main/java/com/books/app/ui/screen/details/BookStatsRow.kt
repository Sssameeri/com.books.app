package com.books.app.ui.screen.details

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
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.StatsDataColor
import com.books.app.ui.resources.StatsDescriptionColor
import com.books.app.ui.resources._01_Sp
import com.books.app.ui.resources._12_Sp
import com.books.app.ui.resources._13_Sp
import com.books.app.ui.resources._18_Sp
import com.books.app.ui.resources._22_Sp

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
            lineHeight = _22_Sp,
            fontSize = _18_Sp,
            letterSpacing = _01_Sp
        )
        Text(
            text = stringResource(id = statsProperty.property.res),
            color = StatsDescriptionColor,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            lineHeight = _13_Sp,
            fontSize = _12_Sp,
            letterSpacing = _01_Sp
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