package com.darnitto.dakemastores.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.darnitto.dakemastores.navigation.ROUT_LOGIN
import com.darnitto.dakemastores.ui.theme.newblue
import com.darnitto.dakemastores.ui.theme.newwhite
import com.darnitto.dakemastores.ui.theme.newyellow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){

    //Navigation
    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(2000)
        navController.navigate(ROUT_LOGIN)

    }
    //End Of Navigation





    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(newblue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.splash),
            contentDescription = "home",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Dakema Stores",
            fontSize = 30.sp,
            color = newwhite,
            fontWeight = FontWeight.ExtraBold,

            )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Your Best Online Shop",
            fontSize = 20.sp,
            color = newyellow,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic

            )

    }

}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){

    SplashScreen(rememberNavController())

}