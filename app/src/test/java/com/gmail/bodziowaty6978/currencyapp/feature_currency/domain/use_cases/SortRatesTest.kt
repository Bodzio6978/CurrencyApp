package com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases

import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.OrderType
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.RateOrder
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class SortRatesTest {
    private lateinit var mockRates: MutableList<Pair<String, Double>>
    private lateinit var sortRatesUseCase: SortRates

    @Before
    fun setUp() {
        mockRates = mutableListOf()
        ('a'..'z').forEachIndexed { index, c ->
            mockRates.add(Pair(c.toString(), index.toDouble()))
        }
        mockRates.shuffle()
        sortRatesUseCase = SortRates()
    }

    @Test
    fun `Order rates by name ascending, correct order`() {
        val sortedRates = sortRatesUseCase(mockRates, RateOrder.Name(OrderType.Ascending))

        for (i in 0..sortedRates.size - 2) {
            assertThat(sortedRates[i].first).isLessThan(sortedRates[i + 1].first)
        }
    }

    @Test
    fun `Order rates by value ascending, correct order`() {
        val sortedRates = sortRatesUseCase(mockRates, RateOrder.Value(OrderType.Ascending))

        for (i in 0..sortedRates.size - 2) {
            assertThat(sortedRates[i].second).isLessThan(sortedRates[i + 1].second)
        }
    }

    @Test
    fun `Order rates by name descending, correct order`() {
        val sortedRates = sortRatesUseCase(mockRates, RateOrder.Name(OrderType.Descending))

        for (i in 0..sortedRates.size - 2) {
            assertThat(sortedRates[i].first).isGreaterThan(sortedRates[i + 1].first)
        }
    }

    @Test
    fun `Order rates by value descending, correct order`() {
        val sortedRates = sortRatesUseCase(mockRates, RateOrder.Value(OrderType.Descending))

        for (i in 0..sortedRates.size - 2) {
            assertThat(sortedRates[i].second).isGreaterThan(sortedRates[i + 1].second)
        }
    }

}