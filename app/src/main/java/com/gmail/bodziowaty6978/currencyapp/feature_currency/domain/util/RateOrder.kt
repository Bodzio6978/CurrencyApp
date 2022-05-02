package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util

sealed class RateOrder(val orderType: OrderType){
    class Name(orderType:OrderType):RateOrder(orderType)
    class Value(orderType:OrderType):RateOrder(orderType)

    fun copy(orderType:OrderType):RateOrder{
        return when(this){
            is Name -> Name(orderType)
            is Value -> Value(orderType)
        }
    }
}