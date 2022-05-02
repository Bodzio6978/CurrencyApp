package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases

import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.data_source.CurrencyApi
import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.repository.CurrencyRepositoryImp
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.OrderType
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.util.Constants
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetCurrencyResponseTest{

    private lateinit var currencyApi:CurrencyApi
    private lateinit var currencyRepository:CurrencyRepository
    private lateinit var sortRates: SortRates

    @Before
    fun setUp(){
        currencyApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(Constants.API_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CurrencyApi::class.java)
        sortRates = SortRates()

        currencyRepository = CurrencyRepositoryImp(currencyApi = currencyApi)

    }

    @Test
    fun `fetch currency response, response code 200`() = runBlocking{
        val response = currencyRepository.getCurrencyResponse("EUR","2022-05-01")
        assertThat(response.code()).isEqualTo(200)
    }






}