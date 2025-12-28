package com.example.whatsappclone.presentation.homescreen

import android.R.attr.horizontalDivider
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import com.example.whatsappclone.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)
fun HomeScreen()
{
    val chatData = listOf(
        ChatDesignModel(
        R.drawable.salman_khan,
            name= "Salman Khan",
            time = "10.00 AM",
            message = "Hello"
        ),
        ChatDesignModel(
            R.drawable.hrithik_roshan,
            name= "Hritik Roshan",
            time = "10.00 AM",
            message = "Hello"

        ),
        ChatDesignModel(
            R.drawable.ajay_devgn,
            name= "Ajay Devgn",
            time = "10.00 AM",
            message = "Hello"

        ),
        ChatDesignModel(
            R.drawable.bhuvan_bam,
            name= "Bhuvan Bam",
            time = "10.00 AM",
            message = "Hello"


        )
    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {},
                containerColor = colorResource(R.color.light_green),


            ) {
                Icon(painter = painterResource(id = R.drawable.chat_icon), contentDescription = null,
                    modifier = Modifier.size(28.dp))
            }
        },
        bottomBar = {
            BottomNavigation()
        }

    ) {
        Column(modifier = Modifier.padding(it)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Whatsapp",
                    fontSize = 28.sp,
                    color = colorResource(id = R.color.light_green),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            HorizontalDivider()
            LazyColumn() {
                items(chatData){
                    ChatDesign(chatDesignModel = it)
                }
            }
        }
    }
}