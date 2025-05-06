package com.darnitto.dakemastores.ui.screens.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.ui.screens.home.HomeScreen

@Composable
fun NotificationsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text("Notifications", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        val notifications = listOf(
            "Your order #1234 has been shipped.",
            "You received ₦5,000 from John.",
            "Credit purchase of ₦2,000 approved.",
            "Delivery scheduled for tomorrow."
        )

        notifications.forEach { message ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview(){
    NotificationsScreen(navController= rememberNavController())
}
