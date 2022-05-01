package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse

sealed class CurrencyResponseState{
    data class Success(val data: CurrencyResponse) : CurrencyResponseState()
    data class Error(val message:String) : CurrencyResponseState()
}
