package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

sealed class CurrenciesUiEvent {
    data class ClickedRate(
        val date: String,
        val currency: String,
        val value: Double
    ):CurrenciesUiEvent()

    data class ShowSnackbar(
        val message: String
    ):CurrenciesUiEvent()
}