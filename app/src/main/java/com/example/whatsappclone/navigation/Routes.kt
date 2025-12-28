package com.example.whatsappclone.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed class Routes {
    @Serializable
    data object SplashScreen : Routes()
    @Serializable
    data object UserRegistrationScreen : Routes()
    @Serializable
    data object WelcomeScreen : Routes()

    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object CallScreen : Routes()
    @Serializable
    data object UpdateScreen : Routes()
    @Serializable
    data object CommunitiesScreen : Routes()
}


