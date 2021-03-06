package com.gmail.bodziowaty6978.currencyapp.feature_currency.data.data_source

import android.provider.SyncStateContract
import com.gmail.bodziowaty6978.currencyapp.BuildConfig
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/{date}")
    suspend fun getCurrencyResponse(
        @Path("date") date:String,
        @Query("base") base:String,
        @Query("access_key") apiKey:String = BuildConfig.API_KEY
    ):Response<CurrencyResponse>
}