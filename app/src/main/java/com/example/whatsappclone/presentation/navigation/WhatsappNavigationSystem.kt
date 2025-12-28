package com.example.whatsappclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.CallScreen.CallScreen
import com.example.whatsappclone.UserRegistrationScreen.UserRegistrationScreen
import com.example.whatsappclone.homescreen.HomeScreen
import com.example.whatsappclone.splashScreen.SplashScreen
import com.example.whatsappclone.updatescreen.CommunitiesScreen
import com.example.whatsappclone.updatescreen.UpdateScreen
import com.example.whatsappclone.welcomeScreen.WelcomeScreen

@Composable
fun WhatsappNavigationSystem()
{
    val navController = rememberNavController()
    NavHost(startDestination = Routes.SplashScreen, navController = navController){
        composable<Routes.SplashScreen>{
            SplashScreen(navController)
        }
        composable<Routes.UserRegistrationScreen>{
            UserRegistrationScreen()
        }
        composable<Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }
        composable<Routes.HomeScreen>{
            HomeScreen()
        }
        composable<Routes.CallScreen>{
            CallScreen()
        }
        composable<Routes.UpdateScreen>{
            UpdateScreen()
        }
        composable<Routes.CommunitiesScreen>{
            CommunitiesScreen()
        }
    }
}