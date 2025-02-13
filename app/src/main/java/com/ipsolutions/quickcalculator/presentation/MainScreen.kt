package com.ipsolutions.quickcalculator.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ipsolutions.quickcalculator.logic.CalculatorEstate
import com.ipsolutions.quickcalculator.ui.theme.DarkGray
import com.ipsolutions.quickcalculator.ui.theme.Gray
import com.ipsolutions.quickcalculator.ui.theme.LCD
import com.ipsolutions.quickcalculator.ui.theme.LightGray
import com.ipsolutions.quickcalculator.ui.theme.OrangeButtons

@Composable
fun MainScreen(vm: CalculatorEstate = viewModel()) {
    val displayText by vm.displayText.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .background(DarkGray, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(DarkGray)
                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                AnimatedContent(
                    targetState = displayText,
                    label = "LCD Animation"
                ) { text ->
                    Text(
                        text = text,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = LCD
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            val buttons = listOf(
                listOf("7", "8", "9", "÷"),
                listOf("4", "5", "6", "×"),
                listOf("1", "2", "3", "-"),
                listOf("0", "C", "=", "+")
            )

            buttons.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    row.forEach { symbol ->
                        CalculatorButton(symbol = symbol) { vm.onButtonClick(symbol) }
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(symbol: String, onClick: () -> Unit) {
    val isOperator = symbol in listOf("÷", "×", "-", "+", "=")
    val buttonColor = if (isOperator) OrangeButtons else LightGray

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .size(64.dp)
            .padding(6.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = symbol,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

