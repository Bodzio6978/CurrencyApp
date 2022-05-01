package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.util

sealed class Screen(val route:String) {
    object CurrenciesScreen:Screen("currencies_screen")
    object RateScreen:Screen("rate_screen")
}