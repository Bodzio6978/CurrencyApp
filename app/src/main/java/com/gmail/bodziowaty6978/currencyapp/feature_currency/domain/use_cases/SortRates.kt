package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.OrderType
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder
import java.util.*

class SortRates() {

    operator fun invoke(
        rates: MutableList<Pair<String, Double>>,
        rateOrder: RateOrder
    ):List<Pair<String,Double>> {
        return when(rateOrder.orderType){
            is OrderType.Ascending -> {
                when (rateOrder) {
                    is RateOrder.Name -> rates.sortedBy { it.first.lowercase(Locale.getDefault()) }
                    is RateOrder.Value -> rates.sortedBy { it.second }

                }
            }
            is OrderType.Descending -> {
                when (rateOrder) {
                    is RateOrder.Name -> rates.sortedByDescending { it.first.lowercase(Locale.getDefault()) }
                    is RateOrder.Value -> rates.sortedByDescending { it.second }
                }
            }
        }

    }


}