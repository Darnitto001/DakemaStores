package com.darnitto.dakemastores.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.navigation.ROUT_CATEGORY
import com.darnitto.dakemastores.navigation.ROUT_DASHBOARD
import com.darnitto.dakemastores.navigation.ROUT_HOME
import com.darnitto.dakemastores.navigation.ROUT_ORDER
import com.darnitto.dakemastores.ui.theme.newblack
import com.darnitto.dakemastores.ui.theme.newblue
import com.darnitto.dakemastores.ui.theme.newblue1
import com.darnitto.dakemastores.ui.theme.newyellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Home Screen") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newblue,
                    titleContentColor = newyellow,
                    navigationIconContentColor = Color.White
                )
            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = newblue
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("DashBoard") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_DASHBOARD)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Favorites") },
                    label = { Text("History") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_ORDER)
                    }
                )


            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Color.LightGray
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {


                //Main Contents of the page
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Text("Welcome to Dakema Stores", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = newblack)
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(modifier = Modifier.fillMaxWidth().height(180.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.dakema),
                            contentDescription = "Banner",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.FillBounds

                        )
                    }



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
        }
    )

    //End of scaffold


}

@Composable
fun BannerSection() {
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
        modifier = Modifier
            .background(newblue)
            .size(100.dp),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(newblue)
                .size(100.dp)

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
            modifier = Modifier
                .background(newblue)
                .fillMaxSize()
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