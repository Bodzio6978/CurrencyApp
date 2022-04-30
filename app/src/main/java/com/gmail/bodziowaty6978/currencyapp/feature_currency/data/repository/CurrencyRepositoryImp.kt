package com.gmail.bodziowaty6978.currencyapp.feature_currency.data.repository

import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.data_source.CurrencyApi
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyRates
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import retrofit2.Response

class CurrencyRepositoryImp(
    private val currencyApi: CurrencyApi
) : CurrencyRepository {

    override suspend fun getCurrencyResponse(
        base: String,
        date: String
    ): Response<CurrencyRates> {
        return currencyApi.getCurrencyResponse(base = base, date = date)
    }
}