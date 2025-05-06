package com.darnitto.dakemastores.ui.screens.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.ui.theme.newblack
import com.darnitto.dakemastores.ui.theme.newblue1

data class OrderItem(val title: String, val quantity: Int, val price: String, val imageRes: Int)

@Composable
fun OrderTrackingScreen(navController: NavHostController) {
    val orderItems = listOf(
        OrderItem("Wireless Earbuds", 1, "$29.99", R.drawable.product1),
        OrderItem("Smart Watch", 2, "$49.99", R.drawable.product2),
        OrderItem("Bluetooth Speaker", 1, "$49.01", R.drawable.product3)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Order Summary & Tracking",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = newblack
        )

        Spacer(modifier = Modifier.height(24.dp))

        OrderSummaryCard(
            orderNumber = "#DKM12345",
            date = "April 30, 2025",
            total = "$128.99",
            status = "Out for Delivery"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Items in this Order", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = newblack)
        Spacer(modifier = Modifier.height(12.dp))

        orderItems.forEach { item ->
            OrderItemRow(item)
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        TrackingSteps(
            steps = listOf("Order Placed", "Processing", "Shipped", "Out for Delivery", "Delivered"),
            currentStep = 3
        )
    }
}

@Composable
fun OrderSummaryCard(orderNumber: String, date: String, total: String, status: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = newblue1),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Order Number: $orderNumber", fontWeight = FontWeight.Medium, color = Color.White)
            Text("Date: $date", color = Color.White)
            Text("Total: $total", color = Color.White)
            Text("Status: $status", fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Composable
fun OrderItemRow(item: OrderItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontWeight = FontWeight.Medium, color = newblack)
                Text("Qty: ${item.quantity}", color = Color.Gray)
            }
            Text(item.price, fontWeight = FontWeight.Bold, color = newblack)
        }
    }
}

@Composable
fun TrackingSteps(steps: List<String>, currentStep: Int) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        steps.forEachIndexed { index, step ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                val color = if (index <= currentStep) newblue1 else Color.Gray
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(color = color, shape = RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(step, color = if (index <= currentStep) newblack else Color.Gray)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun OrderTrackingScreenPreview(){
    OrderTrackingScreen(navController = rememberNavController())
}
