package com.example.threads.Screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.threads.Navigation.Routes
import com.example.threads.R


@Composable
fun LoginPage(navController: NavHostController){

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Image(painter = painterResource(id = R.drawable.login), contentDescription = "",
            modifier = Modifier
                .size(200.dp)
                .alpha(0.7f)
                )

        Text(text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold

            )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email , onValueChange = { email = it },
            label ={ Text(text ="Email")})

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(value = password , onValueChange = { password = it },
            label ={ Text(text ="Password")})

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, end = 60.dp)) {
            Text(text = "Login")
            
        }

        TextButton(onClick = {
            navController.navigate(Routes.Register.routes){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
            }


        }) {
            Text(text = "Create new Account",
                fontWeight = FontWeight.Bold)

        }
    }
}