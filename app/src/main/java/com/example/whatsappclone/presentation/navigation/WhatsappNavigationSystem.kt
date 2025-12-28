package com.example.whatsappclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.presentation.CallScreen.CallScreen
import com.example.whatsappclone.presentation.UserRegistrationScreen.UserRegistrationScreen
import com.example.whatsappclone.presentation.homescreen.HomeScreen
import com.example.whatsappclone.presentation.splashScreen.SplashScreen
import com.example.whatsappclone.presentation.updatescreen.UpdateScreen
import com.example.whatsappclone.presentation.welcomeScreen.WelcomeScreen
import com.example.whatsappclone.updatescreen.CommunitiesScreen

@Composable
fun WhatsappNavigationSystem()
{
    val navController = rememberNavController()
    NavHost(startDestination = Routes.SplashScreen, navController = navController){
        composable<Routes.SplashScreen>{
            SplashScreen(navController)
        }
        composable<Routes.UserRegistrationScreen>{
            UserRegistrationScreen(navController)
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