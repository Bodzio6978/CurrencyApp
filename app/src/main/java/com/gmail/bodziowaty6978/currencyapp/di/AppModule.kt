package com.gmail.bodziowaty6978.currencyapp.di

import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.data_source.CurrencyApi
import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.repository.CurrencyRepositoryImp
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.repository.CurrencyRepository
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases.CurrencyUseCases
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases.GetCurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases.SortRates
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.util.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideCurrencyApi(
        retrofitInstance:Retrofit
    ):CurrencyApi = retrofitInstance.create(CurrencyApi::class.java)

    @Singleton
    @Provides
    fun provideCurrencyRepository(
        currencyApi:CurrencyApi
    ): CurrencyRepository = CurrencyRepositoryImp(currencyApi)

    @Singleton
    @Provides
    fun provideSortRatesUseCase():SortRates = SortRates()

    @Singleton
    @Provides
    fun provideCurrencyUseCases(
        currencyRepository: CurrencyRepository,
        sortRates: SortRates
    ) = CurrencyUseCases(
        getCurrencyResponse = GetCurrencyResponse(currencyRepository,sortRates),
        sortRates = sortRates
    )


}