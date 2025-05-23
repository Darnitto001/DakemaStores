package com.darnitto.dakemastores.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
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
import com.darnitto.dakemastores.navigation.ROUT_CATEGORY
import com.darnitto.dakemastores.navigation.ROUT_HOME
import com.darnitto.dakemastores.navigation.ROUT_NOTIFICATION
import com.darnitto.dakemastores.navigation.ROUT_ORDER
import com.darnitto.dakemastores.navigation.ROUT_PRODUCT_LIST
import com.darnitto.dakemastores.ui.theme.newblue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(newblue),
                title = { Text("Daketa Stores") },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: open drawer or menu */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
        ) {


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Explore Features",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = newblue
            )

            Spacer(modifier = Modifier.height(12.dp))

            DashboardCards(navController)
        }
    }
}

@Composable
fun DashboardCards(navController: NavController) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),


    ) {
            DashboardCard(
                iconRes = R.drawable.about,
                title = "Categories",
                onClick = { navController.navigate(ROUT_CATEGORY) }
            )
            DashboardCard(
                iconRes = R.drawable.support,
                title = "Orders",
                onClick = { navController.navigate(ROUT_ORDER) }
            )
            DashboardCard(
                iconRes = R.drawable.support,
                title = "More Products",
                onClick = { navController.navigate(ROUT_PRODUCT_LIST) }
            )

            DashboardCard(
                iconRes = R.drawable.about,
                title = "Notifications",
                onClick = { navController.navigate(ROUT_NOTIFICATION) }
            )
            DashboardCard(
                iconRes = R.drawable.localshipping,
                title = "Product Detail",
                onClick = { navController.navigate(ROUTE_PRODUCT_DETAIL) }) } // Replace with your cart route
            DashboardCard(
                iconRes = R.drawable.about,
                title = "About Us",
                onClick = { navController.navigate(ROUTE_ABOUT) }
            )

    }


@Composable
fun DashboardCard(iconRes: Int, title: String, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = newblue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { navController.navigate(ROUT_HOME) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Category") },
            label = { Text("Category") },
            selected = false,
                onClick = { navController.navigate(ROUT_CATEGORY) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Notifications, contentDescription = "Notifications") },
            label = { Text("Notify") },
            selected = false,
            onClick = { navController.navigate(ROUT_NOTIFICATION) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}
