package com.example.whatsappclone.presentation.CallScreen


import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

import com.example.whatsappclone.presentation.CommunitiesScreen.CommunitiesData
import com.example.whatsappclone.presentation.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)
fun CallScreen() {


    var SampleCommunities = listOf(
        CommunitiesData(
            R.drawable.neat_roots,
            "Neat Roots",
            273
        ),
        CommunitiesData(
            R.drawable.img,
            "Food Lover",
            129

        ),
        CommunitiesData(
            R.drawable.meta,
            "Meta",
            382 )     )
    val SampleRecentCalls = listOf(
        RecentCallData(
            R.drawable.ajay_devgn,
            "Ajay Devgn",
            "10min ago",
            true
        ),
        RecentCallData
            (
            R.drawable.bhuvan_bam,
            "Bhuvan Bam",
            "15min ago",
                    false
        ),

        )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(id = R.color.light_green),
                modifier = Modifier.size(65.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                    contentDescription = null
                )
            }
        },
        bottomBar = {
            BottomNavigation()
        },
        topBar = {
            CallTopBar()
        }
    ) {


        Column(
            modifier = Modifier
                .padding(it)
        ) {
            FavoritesSection()
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        id = R.color.light_green
                    )

                ),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text("Start a New Call", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Recent Calls",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn() {
                items(SampleRecentCalls) { data ->
                    RecentCallItem(recentCallData = data)
                }

            }
        }

    }
}