package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.OrderType
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: RateOrder = RateOrder.Name(OrderType.Descending),
    onOrderChange: (RateOrder) -> Unit
) {
    Column(
        modifier = modifier,

        ) {

        Text(
            text = "Sort all rates",
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Name", selected = noteOrder is RateOrder.Name, onSelect = {
                onOrderChange(RateOrder.Name(noteOrder.orderType))
            })

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Value", selected = noteOrder is RateOrder.Value, onSelect = {
                onOrderChange(RateOrder.Value(noteOrder.orderType))
            })
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                })

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                })

        }

    }

}