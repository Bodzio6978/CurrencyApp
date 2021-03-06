package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.Rate
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder

sealed class CurrenciesEvent {
    object ClickedMoreButton:CurrenciesEvent()
    data class ClickedRate(val date:String,val rate:Rate):CurrenciesEvent()
    data class ChangedOrder(val rateOrder:RateOrder):CurrenciesEvent()
    object ToggleOrderSection:CurrenciesEvent()
}