package com.darnitto.dakemastores.ui.screens.item

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darnitto.dakemastores.R
import com.darnitto.dakemastores.navigation.ROUT_ORDER
import com.darnitto.dakemastores.ui.theme.newblue
import com.darnitto.dakemastores.ui.theme.newblue1
import com.darnitto.dakemastores.ui.theme.newwhite
import com.darnitto.dakemastores.ui.theme.newyellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize()
    ){

        val mContext = LocalContext.current

        //TopAppBar
        TopAppBar(
            title  = { Text(text = "Health") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = newblue,
                titleContentColor = newwhite,
                navigationIconContentColor = newyellow,
                actionIconContentColor = newyellow
            ),
            //Menu Icon
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            //End

            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
                }
                IconButton(onClick = {
                    navController.navigate(ROUT_ORDER)
                }) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                }
            }
        )
        //End

        Image(
            painter = painterResource(R.drawable.healthy),
            contentDescription = "Health",
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Search Bar
        var search by remember { mutableStateOf("") }

        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp,end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            //trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            placeholder = { Text(text = "Search") }
        )
        //End of Search Bar

        Spacer(modifier = Modifier.height(20.dp))

       Column (modifier = Modifier.verticalScroll(rememberScrollState())){

           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.paracetamol),
                   contentDescription = "paracetamol",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "Biogesic Paracetamol",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "@ Ksh.20 per pair",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.30 ",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.20",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {

                           val callIntent= Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0720245837".toUri()
                           mContext.startActivity(callIntent)

                       },
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row

           Spacer(modifier = Modifier.height(20.dp))

           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.kit),
                   contentDescription = "First Aid",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "First Aid Kit",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "Saves You When you need it",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.3000",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.2800",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {},
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row
           Spacer(modifier = Modifier.height(20.dp))

           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.cyringe),
                   contentDescription = "Cyringe",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "Medicinal Cyringe",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "Use Under Prescriptions",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.2500",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.1300",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {
                           navController.navigate(ROUT_ORDER)
                       },
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row
           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.painkiller),
                   contentDescription = "Painkiller",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "Panadol Extra",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "Relieves pain in seconds",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.800",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.700",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {},
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row
           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.penicillin),
                   contentDescription = "penicillin",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "Penicillin",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "Take under Prescriptions ",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.800",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.700",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {},
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row
           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.mask),
                   contentDescription = "mask",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "Surgical masks",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "100% Safe",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.500",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.450",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {},
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row
           //Row Start
           Row (
               modifier = Modifier.padding(start = 20.dp)
           ){
               Image(
                   painter = painterResource(R.drawable.scalpel),
                   contentDescription = "shop",
                   modifier = Modifier.width(200.dp).height(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.width(20.dp))

               Column (){
                   Text(
                       text = "Scalpel Surgical Blade",
                       fontSize = 20.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Text(
                       text = "Quality Blade, No rusting",
                       fontSize = 15.sp,
                   )
                   Text(
                       text = "Ksh.150",
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       text = "Price : Ksh.100",
                       fontSize = 15.sp,
                   )
                   Row (){
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "",tint = newblue1)
                   }

                   Button(
                       onClick = {},
                       colors = ButtonDefaults.buttonColors(newblue1),
                       shape = RoundedCornerShape(10.dp),
                       modifier = Modifier.fillMaxWidth().padding(end = 20.dp)

                   ) {
                       Text(
                           text = "Order",
                       )
                   }

               }
           }
           //End of Row

       }

    }

}

@Preview(showBackground = true)
@Composable
fun HealthScreenPreview(){

    HealthScreen(rememberNavController())
}