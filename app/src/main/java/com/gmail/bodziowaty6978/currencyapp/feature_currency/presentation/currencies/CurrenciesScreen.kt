package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components.CurrencyResponseSection
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components.GreetingsSection

@Composable
fun CurrenciesScreen(
    viewModel: CurrenciesViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //Hardcoded username
        GreetingsSection(
            username = "Blix",
            isLoadingVisible = viewModel.loadingState.value
        )

        CurrencyResponseSection(
            currencyResponseItems = viewModel.currencyResponseState.value,
            isLoading = viewModel.loadingState.value,
            onEvent = {
                viewModel.onEvent(it)
            }
        )
    }
}