package com.darnitto.dakemastores.ui.screens.service

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.ui.theme.newblue1
import com.darnitto.dakemastores.ui.theme.newblack

@Composable
fun ServicesScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Our Services",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = newblack
        )
        Spacer(modifier = Modifier.height(20.dp))

        val services = listOf(
            ServiceItem("Place Order", R.drawable.order),
            ServiceItem("Track Delivery", R.drawable.delivery),
            ServiceItem("Purchase on Credit", R.drawable.credit),
            ServiceItem("Request Refund", R.drawable.refund),
            ServiceItem("Customer Support", R.drawable.support),
            ServiceItem("Transaction History", R.drawable.history),
            ServiceItem("Manage Account", R.drawable.account),
            ServiceItem("Promotions & Offers", R.drawable.promotions)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            services.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowItems.forEach { service ->
                        ServiceCard(
                            service = service,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (rowItems.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun ServiceCard(service: ServiceItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(140.dp)
            .clickable { /* TODO: Navigate to specific service screen */ },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = newblue1),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = service.iconRes),
                contentDescription = service.title,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = service.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = newblack,
                maxLines = 2
            )
        }
    }
}

data class ServiceItem(val title: String, val iconRes: Int)
@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview(){
    ServicesScreen(navController= rememberNavController())
}
