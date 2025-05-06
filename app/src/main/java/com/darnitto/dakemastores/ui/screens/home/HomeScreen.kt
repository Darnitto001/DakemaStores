package com.darnitto.dakemastores.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.ui.theme.newblack

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Welcome to Dakema Stores", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = newblack)
        Spacer(modifier = Modifier.height(12.dp))

        BannerSection()
        Spacer(modifier = Modifier.height(20.dp))

        Text("Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        CategorySection(navController)
        Spacer(modifier = Modifier.height(20.dp))

        Text("Top Deals", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        TopDealsSection()
    }
}

@Composable
fun BannerSection() {
    Card(modifier = Modifier.fillMaxWidth().height(180.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dakema),
            contentDescription = "Banner",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun CategorySection(navController: NavController) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(5) { index ->
            CategoryCard(title = "Category $index", icon = R.drawable.product) {
                navController.navigate("products/$index")
            }
        }
    }
}

@Composable
fun CategoryCard(title: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier.size(100.dp),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(painter = painterResource(id = icon), contentDescription = title, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title, fontSize = 12.sp)
        }
    }
}

@Composable
fun TopDealsSection() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(5) { index ->
            DealCard(title = "Deal $index", icon = R.drawable.product)
        }
    }
}

@Composable
fun DealCard(title: String, icon: Int) {
    Card(modifier = Modifier.size(width = 140.dp, height = 180.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(painter = painterResource(id = icon), contentDescription = title, modifier = Modifier.size(80.dp))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}