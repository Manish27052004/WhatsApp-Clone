package com.example.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappclone.presentation.UserRegistrationScreen.UserRegistrationScreen
import com.example.whatsappclone.presentation.navigation.WhatsappNavigationSystem
import com.example.whatsappclone.presentation.splashScreen.SplashScreen
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme
import com.example.whatsappclone.presentation.updatescreen.TopBar
import com.example.whatsappclone.presentation.updatescreen.UpdateScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppCloneTheme {
                WhatsappNavigationSystem()
            }
        }
    }
}

