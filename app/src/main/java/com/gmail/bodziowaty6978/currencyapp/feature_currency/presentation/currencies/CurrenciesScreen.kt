package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components.CurrencyResponseSection
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components.OrderSection
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.util.Screen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CurrenciesScreen(
    viewModel: CurrenciesViewModel = hiltViewModel(),
    navController:NavController,
) {
    val scaffoldState = rememberScaffoldState()
    val orderState = viewModel.rateOrderState.value

    LaunchedEffect(key1 = true){
        viewModel.getCurrency()
    }

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
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        //Hardcoded username, if it was real app I would use something like datastore or shared prefs to get username
                        text = "Welcome Blix",
                        style = MaterialTheme.typography.h2
                    )
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                actions = {
                    if (viewModel.loadingState.value){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(16.dp)
                        )
                    }

                    IconButton(onClick = {
                        viewModel.onEvent(
                            CurrenciesEvent.ToggleOrderSection
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Default.Sort,
                            contentDescription = "Sort Icon",
                            tint = Color.White,)
                    }


                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                AnimatedVisibility(
                    visible = orderState.isOrderSectionVisible,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    OrderSection(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                        noteOrder = orderState.rateOrder,
                        onOrderChange = {
                            viewModel.onEvent(CurrenciesEvent.ChangedOrder(it))
                        })
                }

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
}