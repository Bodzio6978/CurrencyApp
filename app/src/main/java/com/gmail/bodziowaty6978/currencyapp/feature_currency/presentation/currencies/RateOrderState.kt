package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.OrderType
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder

data class RateOrderState(
    val isOrderSectionVisible:Boolean = false,
    val rateOrder:RateOrder = RateOrder.Name(OrderType.Ascending)
)