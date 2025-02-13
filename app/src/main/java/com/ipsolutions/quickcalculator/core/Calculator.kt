package com.ipsolutions.quickcalculator.core

import net.objecthunter.exp4j.ExpressionBuilder


class Calculator {
    fun processInput(currentText: String, input: String): String {
        return when (input) {
            "C" -> "0"
            "=" -> evaluator(currentText)
            else -> {
                if (currentText == "0") input else currentText + input
            }
        }
    }

    private fun evaluator(expression: String): String {
        return try {
            val result = ExpressionBuilder(expression.replace("×", "*").replace("÷", "/")).build().evaluate()
            result.toString()
        } catch (e: Exception) {
            "Error"
        }
    }

}