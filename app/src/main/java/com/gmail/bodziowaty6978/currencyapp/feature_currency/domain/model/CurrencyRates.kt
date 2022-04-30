package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyRates(
    @SerialName("base")
    val base: String,
    @SerialName("date")
    val date: String,
    @SerialName("historical")
    val historical: Boolean,
    @SerialName("rates")
    val rates: Map<String,Double>,
    @SerialName("success")
    val success: Boolean,
    @SerialName("timestamp")
    val timestamp: Int
)