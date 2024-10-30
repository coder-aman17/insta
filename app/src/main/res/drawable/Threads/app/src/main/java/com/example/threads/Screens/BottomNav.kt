package com.example.threads.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.threads.Model.BottomNavItem
import com.example.threads.Navigation.Routes

@Composable
fun BottomNAv(navController: NavController) {


    val navController1 = rememberNavController()

    Scaffold(bottomBar = { MyBottomBar(navController1) }) {innerpadding->
        NavHost(navController = navController1, startDestination = Routes.Home.routes,
            modifier = Modifier.padding(innerpadding)) {

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


            
        }


    }

}
@Composable
fun MyBottomBar(navController1: NavHostController)  {
    val backStackEntry = navController1.currentBackStackEntryAsState()
    val list = listOf(
        BottomNavItem(
            "Home",
            Routes.Home.routes,
            Icons.Rounded.Home
    ),

        BottomNavItem(
            "Notification",
            Routes.Notification.routes,
            Icons.Rounded.Notifications
        ),
        BottomNavItem(
            "Profile",
            Routes.Profile.routes,
            Icons.Rounded.Person
        ),
        BottomNavItem(
            "Search",
            Routes.Search.routes,
            Icons.Rounded.Search
        ),

        BottomNavItem(
            "AddThreads",
            Routes.AddThreads.routes,
            Icons.Rounded.Add
        )









    )

    BottomAppBar {
        list.forEach {
            val selected  = it.route == backStackEntry.value?.destination?.route

            NavigationBarItem(selected = selected, onClick = {
                navController1.navigate(it.route){
                    popUpTo(navController1.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop= true
                }
            }, icon = {
                androidx.compose.material3.Icon(imageVector = it.icon, contentDescription =null )
            })
        }
    }
}
