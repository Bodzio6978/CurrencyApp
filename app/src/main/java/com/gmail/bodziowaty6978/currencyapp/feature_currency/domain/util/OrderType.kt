package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}