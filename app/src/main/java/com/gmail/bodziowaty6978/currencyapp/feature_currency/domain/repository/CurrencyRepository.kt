package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyRates
import retrofit2.Response

interface CurrencyRepository {

    suspend fun getCurrencyResponse(
        base:String,
        date:String,
    ): Response<CurrencyRates>
}