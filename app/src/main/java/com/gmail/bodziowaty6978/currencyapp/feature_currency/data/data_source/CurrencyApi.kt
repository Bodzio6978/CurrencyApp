package com.gmail.bodziowaty6978.currencyapp.feature_currency.data.data_source

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyRates
import com.gmail.bodziowaty6978.currencyapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/{date}?access_key=${Constants.API_KEY}")
    suspend fun getCurrencyResponse(
        @Path("date") date:String,
        @Query("base") base:String,
    ):Response<CurrencyRates>
}