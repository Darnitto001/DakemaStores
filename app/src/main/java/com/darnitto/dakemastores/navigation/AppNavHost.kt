package com.darnitto.dakemastores.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.data.UserDatabase
import com.darnitto.dakemastores.repository.UserRepository
import com.darnitto.dakemastores.ui.screens.about.AboutScreen
import com.darnitto.dakemastores.ui.screens.contact.ContactScreen
import com.darnitto.dakemastores.ui.screens.home.HomeScreen
import com.darnitto.dakemastores.viewmodel.AuthViewModel
import com.darnitto.dakemastores.ui.screens.auth.LoginScreen
import com.darnitto.dakemastores.ui.screens.auth.RegisterScreen
import com.darnitto.dakemastores.ui.screens.dashboard.DashboardScreen
import com.darnitto.dakemastores.ui.screens.detail.ProductDetailScreen
import com.darnitto.dakemastores.ui.screens.notification.NotificationsScreen
import com.darnitto.dakemastores.ui.screens.product.EditProductScreen
import com.darnitto.dakemastores.ui.screens.product.ProductViewModel
import com.darnitto.dakemastores.ui.screens.product.ProductlistingScreen
import com.darnitto.dakemastores.ui.screens.service.ServicesScreen
import com.darnitto.dakemastores.ui.screens.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH, // First screen Display
    productViewModel: ProductViewModel = viewModel(),

    ) {

    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(ROUT_NOTIFICATION) {
            NotificationsScreen(navController)
        }

        composable(ROUT_SERVICE) {
            ServicesScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_ORDER) {
            SplashScreen(navController)
        }




        composable(
            "product/{productName}/{productPrice}/{imageResId}",
            arguments = listOf(
                navArgument("productName") { type = NavType.StringType },
                navArgument("productPrice") { type = NavType.StringType },
                navArgument("imageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val productName = backStackEntry.arguments?.getString("productName") ?: ""
            val productPrice = backStackEntry.arguments?.getString("productPrice") ?: ""
            val imageResId = backStackEntry.arguments?.getInt("imageResId") ?: 0

            ProductDetailScreen(
                name = productName,
                price = productPrice,
                imageResId = imageResId,
                navController = navController
            )
        }

        composable(
            "product_detail/{name}/{price}/{imageResId}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType },
                navArgument("imageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            val imageResId = backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.refund

            ProductDetailScreen(name, price, imageResId, navController)
        }




        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductlistingScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }







    }
}