package com.example.threads.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.threads.Navigation.Routes
import com.example.threads.R


@Composable
fun Register(navController: NavHostController) {
    var Name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")

    }
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var bio by remember {
        mutableStateOf("")
    }









    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){



        Text(text = "SignUp Here",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold

        )
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile",
            modifier = Modifier.size(100.dp).clip(CircleShape).background(Color.Gray).clickable {


            })




        Spacer(modifier = Modifier.height(10.dp))



        OutlinedTextField(value = Name , onValueChange = { Name = it },
            label ={ Text(text ="Name") })
        Spacer(modifier = Modifier.height(10.dp))
        
        OutlinedTextField(value = username , onValueChange = { username = it },
            label ={ Text(text ="username") })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email , onValueChange = { email = it },
            label ={ Text(text ="Email") })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password , onValueChange = { password = it },
            label ={ Text(text ="Password") })

        Spacer(modifier = Modifier.height(10.dp))


        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = bio , onValueChange = { bio = it },
            label ={ Text(text ="Bio") })

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedButton(onClick = {
            navController.navigate(Routes.bottomnav.routes)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, end = 60.dp)) {
            Text(text = "Register")

        }

TextButton(onClick = {

   navController.navigate(Routes.LoginPage.routes){
       popUpTo(navController.graph.startDestinationId)
       launchSingleTop = true
   }
}) {
    Text(text = "Already have an account? login")

}
    }
}