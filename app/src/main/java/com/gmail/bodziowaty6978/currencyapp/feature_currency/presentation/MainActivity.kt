package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.CurrenciesScreen
import com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.util.Screen
import com.gmail.bodziowaty6978.currencyapp.ui.theme.CurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CurrenciesScreen.route
                    ){
                        composable(
                            route = Screen.CurrenciesScreen.route
                        ){
                            CurrenciesScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}
