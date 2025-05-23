package com.darnitto.dakemastores.ui.screens.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.darnitto.dakemastores.ui.theme.newblue
import com.darnitto.dakemastores.ui.theme.newblack

@Composable
fun CheckoutScreen(navController: NavController) {
    var address by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var paymentMethod by remember { mutableStateOf("Credit Card") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Text("Checkout", fontSize = 24.sp, color = newblack)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Shipping Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Select Payment Method", color = newblack)
        Spacer(modifier = Modifier.height(8.dp))

        val options = listOf("Credit Card", "Pay on Delivery", "Mobile Money")
        options.forEach { method ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { paymentMethod = method }
            ) {
                RadioButton(
                    selected = (paymentMethod == method),
                    onClick = { paymentMethod = method }
                )
                Text(method)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Handle order submission
                navController.navigate("order_summary")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = newblue)
        ) {
            Text("Place Order", color = Color.White, fontSize = 18.sp)
        }
    }
}



