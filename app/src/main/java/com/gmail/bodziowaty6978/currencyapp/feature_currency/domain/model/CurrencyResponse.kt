package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponse(
    @SerialName("base")
    val base: String,
    @SerialName("date")
    val date: String,
    @SerialName("historical")
    val historical: Boolean,
    @SerialName("rates")
    var rates: Map<String,Double>,
    @SerialName("success")
    val success: Boolean,
    @SerialName("timestamp")
    val timestamp: Int
)