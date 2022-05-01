package com.gmail.bodziowaty6978.currencyapp.feature_currency.presentation.currencies.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GreetingsSection(
    username:String,
    isLoadingVisible:Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Welcome $username!",
            style = MaterialTheme.typography.h2
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isLoadingVisible){
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(16.dp)
                )
            }

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Default.Sort, contentDescription = "Filter Icon")
            }
        }
    }
    
}