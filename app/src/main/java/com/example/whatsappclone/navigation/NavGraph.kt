package com.example.whatsappclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.presentation.screens.PhoneAuthScreen
import com.example.whatsappclone.presentation.profile.UserProfileSetScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "phone_auth") {
        composable("phone_auth") {
            PhoneAuthScreen(navController = navController)
        }
        composable("profile_set") {
            UserProfileSetScreen(navController = navController)
        }
        composable("main") {
            // Your main app screen will go here
        }
    }
}
