package com.gmail.bodziowaty6978.currencyapp.feature_currency.data

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import retrofit2.Response

class FakeCurrencyRepository:CurrencyRepository {

    override suspend fun getCurrencyResponse(
        base: String,
        date: String
    ): Response<CurrencyResponse> {
        TODO("Not yet implemented")
    }
}