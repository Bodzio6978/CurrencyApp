package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gmail.bodziowaty6978.currencyapp.R
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.Rate
import com.gmail.bodziowaty6978.currencyapp.ui.theme.Grey
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CurrencyResponseItem(
    currencyResponse: CurrencyResponse
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Grey)
            .padding(horizontal = 15.dp, vertical = 5.dp)
    ) {
        Text(
            text = currencyResponse.date,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .padding(vertical = 5.dp)
        )

        Text(
            text = stringResource(id = R.string.rates),
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(bottom = 5.dp)
        )

        FlowRow(
            mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
            mainAxisSize = SizeMode.Expand,
        ) {
            currencyResponse.rates.forEach { (currency, value) ->
                RateItem(
                    rate = Rate(
                        currency = currency,
                        value = value
                    ),
                    // -25 because this layout has combined padding of 25
                    itemSize = (LocalConfiguration.current.screenWidthDp / 2)-25
                )
            }

        }
    }
}