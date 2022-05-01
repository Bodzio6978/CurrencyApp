package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.CurrenciesEvent

@Composable
fun CurrencyResponseSection(
    currencyResponseItems: List<CurrencyResponse>,
    isLoading: Boolean,
    onEvent: (CurrenciesEvent) -> Unit
) {

    val listState = rememberLazyListState()

        LazyColumn(
            state = listState
        ) {
            items(currencyResponseItems.size) {
                CurrencyResponseItem(
                    currencyResponse = currencyResponseItems[it],
                    onCurrencyResponseEvent = { event ->
                        onEvent(event)
                    },
                    isLoadingVisible = it==currencyResponseItems.size-1,
                    areItemsLoaded = isLoading
                )
            }

//            if ((currencyResponseItems.size - 1) - listState.firstVisibleItemIndex == listState.layoutInfo.visibleItemsInfo.size - 1&& !isLoading) {
//                Log.e(TAG,listState.layoutInfo.visibleItemsInfo.size.toString())
//                onEvent(CurrenciesEvent.ScrolledToTheBottom)
//                numberOfItems = listState.firstVisibleItemIndex
//                Log.e(TAG, "Scrolled to the bottom")
//            }

        }
}