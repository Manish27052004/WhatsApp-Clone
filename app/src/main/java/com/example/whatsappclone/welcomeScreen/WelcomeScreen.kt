package com.example.whatsappclone.welcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.navigation.Routes

@Composable

fun WelcomeScreen(navHostController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.whatsapp_sticker)
            , contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        Text("Welcome WhatsApp",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
            )
        Spacer(modifier = Modifier.height(24.dp))

        Row{
            Text("Read our", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Privacy Policy", color = colorResource(id= R.color.light_green))
            Text("Tap 'Agree and Continue' to", color= Color.Gray)
        }
        Row{
            Text("accept the", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Terms of Service", color = colorResource(id= R.color.light_green))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navHostController.navigate(Routes.UserRegistrationScreen)
        }, modifier = Modifier.size(280.dp, 50.dp), shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_green))
        ) {
            Text("Agree and Continue", color = Color.White, fontSize = 20.sp)
        }
    }
}