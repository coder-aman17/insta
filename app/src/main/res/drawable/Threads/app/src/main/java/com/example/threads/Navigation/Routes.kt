package com.example.threads.Navigation

sealed class Routes (val routes : String ) {

    object Home : Routes("Home")
    object bottomnav : Routes("bottomnav")
    object Notification : Routes("Notification")
    object Profile : Routes("Profile")
    object Search : Routes("Search")
    object splash : Routes("splash")
    object AddThreads : Routes("AddThreads")
    object LoginPage: Routes("login")
    object Register : Routes("register")
}



