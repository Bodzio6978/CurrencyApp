package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases

import android.util.Log
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.CurrencyResponseState
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.OrderType
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder

class GetCurrencyResponse(
    private val repository: CurrencyRepository,
    private val sortRates: SortRates
){

    suspend operator fun invoke(base:String = "EUR",date:String, rateOrder: RateOrder): CurrencyResponseState {
        return try {
            val result = repository.getCurrencyResponse(
                base = base,
                date = date
            )
            if (result.isSuccessful && result.body() != null) {
                val item = result.body()
                if (item!=null){
                    val sortedRates = sortRates(
                        rates = item.rates.toList().toMutableList(),
                        rateOrder = rateOrder)
                    item.rates = sortedRates.toMap()
                    CurrencyResponseState.Success(item)
                }else{
                    CurrencyResponseState.Error("Empty body")
                }
            }else{
                CurrencyResponseState.Error("Something went wrong")
            }
        } catch (e: Exception) {
            CurrencyResponseState.Error(e.message.toString())
        }

    }
}