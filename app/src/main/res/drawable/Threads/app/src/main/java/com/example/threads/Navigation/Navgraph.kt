package com.example.threads.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.threads.Screens.AddThreads
import com.example.threads.Screens.BottomNAv
import com.example.threads.Screens.Home
import com.example.threads.Screens.LoginPage
import com.example.threads.Screens.Notification
import com.example.threads.Screens.Profile
import com.example.threads.Screens.Register
import com.example.threads.Screens.Search
import com.example.threads.Screens.Splash

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination =Routes.splash.routes) {

        composable(Routes.splash.routes) {
            Splash(navController = navController)

        }

        composable(Routes.bottomnav.routes) {
            BottomNAv(navController = navController)
        }

        composable(Routes.AddThreads.routes){
            AddThreads()
        }

        composable(Routes.Notification.routes){
            Notification()
        }

        composable(Routes.Home.routes){
            Home()
        }

        composable(Routes.Profile.routes){
            Profile()
        }

        composable(Routes.Search.routes){
            Search()
        }
        composable(Routes.LoginPage.routes){
            LoginPage(navController = navController)

        }
        composable(Routes.Register.routes){
            Register(navController = navController)
        }

    }



    }

