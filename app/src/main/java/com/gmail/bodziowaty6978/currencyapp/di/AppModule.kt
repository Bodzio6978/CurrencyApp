package com.gmail.bodziowaty6978.currencyapplication.di

import com.gmail.bodziowaty6978.currencyapplication.feature_currency.data.data_source.CurrencyApi
import com.gmail.bodziowaty6978.currencyapplication.feature_currency.data.repository.CurrencyRepositoryImp
import com.gmail.bodziowaty6978.currencyapplication.feature_currency.domain.repository.CurrencyRepository
import com.gmail.bodziowaty6978.currencyapplication.feature_currency.domain.use_cases.GetCurrencyResponse
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
        .baseUrl("http://api.exchangeratesapi.io/v1/")
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
    ):CurrencyRepository = CurrencyRepositoryImp(currencyApi)

    @Singleton
    @Provides
    fun provideGetCurrencyResponseUseCase(
        currencyRepository: CurrencyRepository
    ) = GetCurrencyResponse(currencyRepository)


}