package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components.CurrencyResponseSection
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components.GreetingsSection
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.util.Screen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CurrenciesScreen(
    viewModel: CurrenciesViewModel = hiltViewModel(),
    navController:NavController
) {

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true){
        viewModel.uiEventFlow.collectLatest { uiEvent ->
            when(uiEvent){
                is CurrenciesUiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(uiEvent.message)
                }
                is CurrenciesUiEvent.ClickedRate -> {
                    navController.navigate(Screen.RateScreen.route + "?date=${uiEvent.date}&value=${uiEvent.value.toFloat()}&currency=${uiEvent.currency}")
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
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
}