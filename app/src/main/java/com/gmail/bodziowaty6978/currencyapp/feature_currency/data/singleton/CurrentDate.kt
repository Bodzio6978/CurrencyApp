package com.gmail.bodziowaty6978.currencyapp.feature_currency.data.singleton

import java.time.LocalDate
import java.util.*

//Made this an object just to be sure that it will never get destroyed and change without my knowledge, so that the date will be consistent
object CurrentDate {
    var currentDate: LocalDate = LocalDate.now()
}