package com.darnitto.dakemastores.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.model.Category
import com.darnitto.dakemastores.navigation.ROUT_BEAUTY
import com.darnitto.dakemastores.navigation.ROUT_ELECTRONICS
import com.darnitto.dakemastores.navigation.ROUT_FASHION
import com.darnitto.dakemastores.navigation.ROUT_HEALTH
import com.darnitto.dakemastores.navigation.ROUT_KITCHEN
import com.darnitto.dakemastores.navigation.ROUT_ORDER
import com.darnitto.dakemastores.navigation.ROUT_SPORTS
import com.darnitto.dakemastores.navigation.ROUT_TOOLS
import com.darnitto.dakemastores.navigation.ROUT_TOYS
import com.darnitto.dakemastores.ui.theme.newblue1
import com.darnitto.dakemastores.ui.theme.newblack
import com.darnitto.dakemastores.ui.theme.newblue

@Composable
fun CategoryScreen(navController: NavController) {
    val categories = listOf(
        Category("Electronics", R.drawable.electronics) {
            navController.navigate(ROUT_ELECTRONICS)
        },
        Category("Fashion", R.drawable.fashion) {
            navController.navigate(ROUT_FASHION)
        },
        Category("Home & Kitchen", R.drawable.kitchen) {
            navController.navigate(ROUT_KITCHEN)
        },
        Category("Tools", R.drawable.tools) {
            navController.navigate(ROUT_TOOLS)
        },
        Category("Toys", R.drawable.toys) {
            navController.navigate(ROUT_TOYS)
        },
        Category("Health", R.drawable.health) {
            navController.navigate(ROUT_HEALTH)
        },
        Category("Beauty", R.drawable.beauty) {
            navController.navigate(ROUT_BEAUTY)
        },
        Category("Sports", R.drawable.sports) {
            navController.navigate(ROUT_SPORTS)
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Shop by Category",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = newblack
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category = category, onClick = category.onClick)
            }
        }
    }
}


@Composable
fun CategoryCard(category: Category, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = newblue),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = category.iconRes),
                contentDescription = category.title,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.title,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = newblack
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview(){
    CategoryScreen(navController= rememberNavController())
}
