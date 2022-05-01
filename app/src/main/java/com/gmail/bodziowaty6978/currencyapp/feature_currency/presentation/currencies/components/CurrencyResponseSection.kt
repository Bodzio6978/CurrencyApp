package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.CurrenciesEvent
import com.gmail.bodziowaty6978.currencyapp.util.TAG

@Composable
fun CurrencyResponseSection(
    currencyResponseItems: List<CurrencyResponse>,
    isLoading: Boolean,
    onEvent: (CurrenciesEvent) -> Unit
) {

    val listState = rememberLazyListState()

    var itemsNumber by remember {
        mutableStateOf(0)
    }


    LazyColumn(
        state = listState,
    ) {
        items(currencyResponseItems.size) {
            CurrencyResponseItem(currencyResponse = currencyResponseItems[it])
        }
        if ((currencyResponseItems.size - 1) - listState.firstVisibleItemIndex == listState.layoutInfo.visibleItemsInfo.size - 1 && !isLoading) {
            onEvent(CurrenciesEvent.ScrolledToTheBottom)
            Log.e(TAG, "Scrolled to the bottom")
        }
    }
}