package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
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

    LazyColumn(
        state = listState,
    ) {
        items(currencyResponseItems.size) {
            CurrencyResponseItem(
                currencyResponse = currencyResponseItems[it],
                onRateClicked = { pair ->
                    onEvent(CurrenciesEvent.ClickedRate(pair.first,pair.second))
                }
            )
        }
        if ((currencyResponseItems.size - 1) - listState.firstVisibleItemIndex == listState.layoutInfo.visibleItemsInfo.size - 1 && !isLoading) {
            onEvent(CurrenciesEvent.ScrolledToTheBottom)
            Log.e(TAG, "Scrolled to the bottom")
        }
    }
}