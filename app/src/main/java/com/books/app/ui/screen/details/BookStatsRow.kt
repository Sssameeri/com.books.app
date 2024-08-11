package com.books.app.ui.screen.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.books.app.ui.resources.NunitoSans
import com.books.app.ui.resources.StatsDataColor
import com.books.app.ui.resources.StatsDescriptionColor
import com.books.app.ui.resources._01_Sp
import com.books.app.ui.resources._10_Dp
import com.books.app.ui.resources._12_Sp
import com.books.app.ui.resources._13_Sp
import com.books.app.ui.resources._18_Sp
import com.books.app.ui.resources._22_Sp

@Composable
fun BookStatsRow(
    stats: List<StatsProperty>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            stats.forEach {
                BookStatsItem(statsProperty = it)
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(top = _10_Dp)
        )
    }
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
            letterSpacing = _01_Sp,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = stringResource(id = statsProperty.property.res),
            color = StatsDescriptionColor,
            fontFamily = NunitoSans,
            fontWeight = FontWeight.SemiBold,
            lineHeight = _13_Sp,
            fontSize = _12_Sp,
            letterSpacing = _01_Sp,
            overflow = TextOverflow.Ellipsis
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