package com.darnitto.dakemastores.ui.screens.dashboard

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.ui.theme.newblack
import com.darnitto.dakemastores.ui.theme.newblue
import com.darnitto.dakemastores.ui.theme.newblue1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize().background(newblue)
    ){

        //Start of Box
        Box (){

            //Card start
            Card (
                modifier = Modifier.fillMaxWidth().height(300.dp),
                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
                colors = CardDefaults.cardColors(newblue1)
            ){


                //TopAppBar
                TopAppBar(
                    title = { Text(text = "Dashboard Section") },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                        }




                    }
                )
                //End TopAppBar

                Image(
                    painter = painterResource(R.drawable.dakema),
                    contentDescription = "home",
                    modifier = Modifier.fillMaxWidth().height(240.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            //End of card

            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .align(alignment = Alignment.BottomCenter)
                    .padding(start = 20.dp, end = 20.dp)
                    .offset(y = 90.dp)

            ){
                Text(
                    text = "For the past years we have always ensured that our sevices are of High Quality and that our customers are satisfied with what we offer as we also deliver our products at the door step of our customers.",
                    fontSize = 20.sp,
                    color = newblack,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )






            }

        }
        //End of Box

        Spacer(modifier = Modifier.height(100.dp))

        //Start of row
        Row (modifier = Modifier.padding(start = 35.dp)){

            //Card one
            Card (
                modifier = Modifier.width(150.dp).height(200.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.home),
                        contentDescription = "home",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "Home", fontSize = 15.sp)
                }
            }
            //End of card one

            Spacer(modifier = Modifier.width(20.dp))

            //Card two
            Card (
                modifier = Modifier.width(150.dp).height(200.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.about),
                        contentDescription = "about",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "About", fontSize = 15.sp)
                }
            }
            //End of card two


        }
        //End of row

        Spacer(modifier = Modifier.height(20.dp))

        //Start of row
        Row (modifier = Modifier.padding(start = 35.dp)){

            //Card one
            Card (
                modifier = Modifier.width(150.dp).height(200.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.contact),
                        contentDescription = "contact",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "Contact Us", fontSize = 15.sp)
                }
            }
            //End of card one

            Spacer(modifier = Modifier.width(20.dp))

            //Card two
            Card (
                modifier = Modifier.width(150.dp).height(200.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.product),
                        contentDescription = "product",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "Products", fontSize = 15.sp)
                }
            }
            //End of card two


        }
        //End of row


    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())

}