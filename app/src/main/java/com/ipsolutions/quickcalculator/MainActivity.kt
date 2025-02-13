package com.ipsolutions.quickcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ipsolutions.quickcalculator.logic.CalculatorEstate
import com.ipsolutions.quickcalculator.presentation.MainScreen
import com.ipsolutions.quickcalculator.ui.theme.QuickCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val vm: CalculatorEstate = viewModel()
                    MainScreen(vm)
                }
            }
        }
    }
}