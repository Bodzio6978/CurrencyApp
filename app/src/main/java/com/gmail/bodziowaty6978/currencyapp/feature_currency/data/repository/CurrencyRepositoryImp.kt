package com.gmail.bodziowaty6978.currencyapp.feature_currency.data.repository

import android.util.Log
import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.data_source.CurrencyApi
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import com.gmail.bodziowaty6978.currencyapp.util.TAG
import retrofit2.Response

class CurrencyRepositoryImp(
    private val currencyApi: CurrencyApi
) : CurrencyRepository {

    override suspend fun getCurrencyResponse(
        base: String,
        date: String
    ): Response<CurrencyResponse> {
        val response = currencyApi.getCurrencyResponse(base = base, date = date)
        return response
    }
}