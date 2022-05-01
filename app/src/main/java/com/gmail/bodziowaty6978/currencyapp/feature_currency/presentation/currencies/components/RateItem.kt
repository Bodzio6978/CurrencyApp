package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.Rate

@Composable
fun RateItem(
    itemSize:Int,
    rate: Rate
) {

    Row(
        modifier = Modifier.width(itemSize.dp)
    ) {
        Text(
            text = "${rate.currency} = ${rate.value}",
            style = MaterialTheme.typography.body2,
            modifier =
                Modifier.padding(vertical = 2.dp)
        )
    }

}