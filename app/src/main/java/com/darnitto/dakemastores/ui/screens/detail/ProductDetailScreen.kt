package com.darnitto.dakemastores.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.ui.theme.newblack
import com.darnitto.dakemastores.ui.theme.newblue

@Composable
fun ProductDetailScreen(
    name: String,
    price: String,
    imageResId: Int,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(newblue)
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = newblack
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Price: $price",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = newblack
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This is a detailed description of $name. You can add full specifications, seller info, or anything else needed.",
            fontSize = 16.sp,
            color = newblack
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* TODO: Add to cart or start checkout */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buy Now")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    val sampleName = "Sample Product"
    val samplePrice = "29.99"
    val sampleImageResId = android.R.drawable.ic_menu_gallery // Replace with your actual drawable if needed

    ProductDetailScreen(
        name = sampleName,
        price = samplePrice,
        imageResId = sampleImageResId,
        navController = rememberNavController()
    )
}