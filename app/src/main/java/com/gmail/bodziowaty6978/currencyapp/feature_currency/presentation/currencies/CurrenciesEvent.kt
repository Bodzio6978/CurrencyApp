package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.Rate

sealed class CurrenciesEvent {
    object ScrolledToTheBottom:CurrenciesEvent()
    data class ClickedRate(val date:String,val rate:Rate):CurrenciesEvent()
}