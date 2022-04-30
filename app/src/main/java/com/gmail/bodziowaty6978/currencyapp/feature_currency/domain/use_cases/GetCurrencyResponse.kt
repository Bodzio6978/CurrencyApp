package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases

import android.util.Log
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.CurrencyResponseState

class GetCurrencyResponse(
    private val repository: CurrencyRepository
){

    suspend operator fun invoke(base:String = "EUR",date:String): CurrencyResponseState {
        return try {
            val result = repository.getCurrencyResponse(
                base = base,
                date = date
            )
            if (result.isSuccessful && result.body() != null) {
                CurrencyResponseState.Success(result.body()!!)
            }else{
                CurrencyResponseState.Error("Something went wrong")
            }
        } catch (e: Exception) {
            CurrencyResponseState.Error(e.message.toString())
        }

    }
}