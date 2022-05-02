package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.bodziowaty6978.currencyapp.feature_currency.data.singleton.CurrentDate
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.model.CurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases.CurrencyUseCases
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.use_cases.GetCurrencyResponse
import com.gmail.bodziowaty6978.currencyapp.feature_currency.domain.util.CurrencyResponseState
import com.gmail.bodziowaty6978.currencyapp.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val currencyUseCases:CurrencyUseCases
): ViewModel(){

    private val _currencyResponseState = mutableStateOf<List<CurrencyResponse>>(emptyList())
    val currencyResponseState: State<List<CurrencyResponse>> = _currencyResponseState

    private val _loadingState = mutableStateOf<Boolean>(false)
    val loadingState: State<Boolean> = _loadingState

    private val _uiEventFlow = MutableSharedFlow<CurrenciesUiEvent>()
    val uiEventFlow: SharedFlow<CurrenciesUiEvent> = _uiEventFlow

    private val _rateOrderState = mutableStateOf<RateOrderState>(RateOrderState())
    val rateOrderState: State<RateOrderState> = _rateOrderState


    fun onEvent(event:CurrenciesEvent){
        when(event){
            is CurrenciesEvent.ClickedMoreButton -> {
                _loadingState.value = true
                CurrentDate.currentDate = CurrentDate.currentDate.minusDays(1)
                getCurrency()
            }
            is CurrenciesEvent.ClickedRate -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(
                        CurrenciesUiEvent.ClickedRate(
                            date = event.date,
                            currency = event.rate.currency,
                            value = event.rate.value
                        )
                    )
                }
            }
            is CurrenciesEvent.ToggleOrderSection -> {
                _rateOrderState.value = rateOrderState.value.copy(
                    isOrderSectionVisible = !rateOrderState.value.isOrderSectionVisible
                )
            }
            is CurrenciesEvent.ChangedOrder -> {
                viewModelScope.launch(Dispatchers.Default) {
                    _loadingState.value = true
                    val currentItems = _currencyResponseState.value.toMutableList()
                    currentItems.forEach { currencyResponse ->
                        val rates = currencyResponse.rates.toList().toMutableList()
                        val sortedRates = currencyUseCases.sortRates(rates = rates, rateOrder = event.rateOrder).toMap()
                        currencyResponse.rates = sortedRates
                    }
                    _rateOrderState.value = rateOrderState.value.copy(
                        rateOrder = event.rateOrder
                    )
                    _loadingState.value = false
                }
            }
        }
    }


    fun getCurrency(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = currencyUseCases.getCurrencyResponse(
                date = CurrentDate.currentDate.toString(),
                rateOrder = _rateOrderState.value.rateOrder
            )
            _loadingState.value = true
            when(result){
                is CurrencyResponseState.Success -> {
                    val currentItems = currencyResponseState.value.toMutableList()
                    currentItems.add(result.data)
                    currentItems.sortByDescending { it.date }
                    _currencyResponseState.value = currentItems
                }
                is CurrencyResponseState.Error -> {
                    Log.e(TAG,result.message)
                }
            }
            _loadingState.value = false
            Log.e(TAG,"Received $result")
        }
    }

}