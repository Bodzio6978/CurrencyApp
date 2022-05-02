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

            //Here is a part of code that gets new currency response instantly when user scrolls to the end of list but it's really performance impactful
            // and I was not able to find a better alternative so I decided to just implement a simple button to get new item

//            if ((currencyResponseItems.size - 1) - listState.firstVisibleItemIndex == listState.layoutInfo.visibleItemsInfo.size - 1&& !isLoading) {
//                onEvent(CurrenciesEvent.ScrolledToTheBottom)
//                numberOfItems = listState.firstVisibleItemIndex
//                Log.e(TAG, "Scrolled to the bottom")
//            }

        }
}