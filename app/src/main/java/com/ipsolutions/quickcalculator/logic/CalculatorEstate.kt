package com.ipsolutions.quickcalculator.logic


import androidx.lifecycle.ViewModel
import com.ipsolutions.quickcalculator.core.Calculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorEstate : ViewModel() {
    private val calculator = Calculator()

    private val _displayText = MutableStateFlow("0")
    val displayText = _displayText.asStateFlow()

    fun onButtonClick(symbol: String) {
        _displayText.value = calculator.processInput(_displayText.value, symbol)
    }
}