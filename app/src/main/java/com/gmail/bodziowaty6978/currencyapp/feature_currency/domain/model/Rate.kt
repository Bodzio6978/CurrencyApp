package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rate(
    @SerialName("currency")
    val currency:String,
    @SerialName("value")
    val value:Double
)
