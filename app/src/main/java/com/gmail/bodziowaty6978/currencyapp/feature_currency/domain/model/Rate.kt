package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Rate(
    val currency:String,
    val value:Double
)
