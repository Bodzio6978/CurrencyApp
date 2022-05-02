package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases

//Decided to go with use cases, that hold all of my business logic, and provide them with dagger hilt because it is so much easier to test a single class
data class CurrencyUseCases (
    val getCurrencyResponse:GetCurrencyResponse,
    val sortRates: SortRates
)