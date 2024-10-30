package com.example.threads

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.threads.Navigation.NavGraph
import com.example.threads.Screens.Splash
import com.example.threads.ui.theme.ThreadsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThreadsTheme {

                val navController = rememberNavController()
                NavGraph(navController = navController)


            }
        }
    }
}

