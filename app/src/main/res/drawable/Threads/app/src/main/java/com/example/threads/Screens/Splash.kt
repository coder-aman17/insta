package com.example.threads.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.threads.Navigation.Routes
import com.example.threads.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController){

    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (image) = createRefs()
        Image(painter = painterResource(id = R.drawable.threads ), contentDescription = "",
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(120.dp))


    }
    

    LaunchedEffect(true) {
        delay(3000)

        if (FirebaseAuth.getInstance().currentUser !=null){
            navController.navigate(Routes.bottomnav.routes){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }


        }
        else{
            navController.navigate(Routes.Register.routes){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }



        
    }
}