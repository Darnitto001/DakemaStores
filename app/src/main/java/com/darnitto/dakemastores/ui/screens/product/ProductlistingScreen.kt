package com.darnitto.dakemastores.ui.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.model.Product
import com.darnitto.dakemastores.ui.theme.newblue1
import com.darnitto.dakemastores.ui.theme.newblack
import com.darnitto.dakemastores.R

@Composable
fun ProductlistingScreen(navController: NavController, categoryName: String) {
    val allProducts = listOf(
        Product("Wireless Earbuds", "$25", R.drawable.earbuds, "Electronics"),
        Product("Smart Watch", "$45", R.drawable.smartwatch, "Electronics"),
        Product("Blender", "$30", R.drawable.blender, "Home & Kitchen"),
        Product("Sneakers", "$60", R.drawable.sneakers, "Fashion"),
        Product("Soccer Ball", "$15", R.drawable.ball, "Sports"),
        Product("Lipstick", "$10", R.drawable.lipstick, "Beauty")
    )

    val filteredProducts = allProducts.filter { it.category == categoryName }

    Column(
        modifier = Modifier
            .fillMaxSize() // ✅ Make screen fill full height/width
            .padding(16.dp)
    ) {
        Text(
            text = categoryName,
            fontSize = 24.sp,
            color = newblack,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(), // ✅ Make grid expand to fill remaining space
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredProducts) { product ->
                ProductCard(product = product, navController = navController)
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, navController: NavController) {
    Card(
        modifier = Modifier
            .height(220.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate("product_detail/${product.name}/${product.price}/${product.imageRes}")
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = newblue1),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 8.dp)
            )
            Text(product.name, fontSize = 14.sp, color = newblack)
            Spacer(modifier = Modifier.height(4.dp))
            Text(product.price, fontSize = 16.sp, color = newblack, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProductlistingScreenPreview() {
    ProductlistingScreen(
        navController = rememberNavController(),
        categoryName = "Electronics" // Choose from existing categories like "Electronics", "Fashion", etc.
    )
}