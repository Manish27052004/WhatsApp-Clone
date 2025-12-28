package com.example.whatsappclone.presentation.updatescreen

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
import com.example.whatsappclone.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)
fun UpdateScreen() {
    val scrollState = rememberScrollState()
    var SampleStatus = listOf(

        StatusData(
            R.drawable.salman_khan,
            "Salman Khan",
            "3min ago"
        ),
        StatusData(
            R.drawable.hrithik_roshan,
            "Hrithik Roshan",
            "5min ago"

        ),
        StatusData(
            R.drawable.ajay_devgn,
            "Ajay Devgn",
            "10min ago"
        ),
        StatusData(
            R.drawable.bhuvan_bam,
            "Bhuvan Bam",
            "15min ago"
        )
    )
    val SampleChannels = listOf(
        ChannelData(
            R.drawable.neat_roots,
            "Neat Roots",
            "Latest News for tech"
        ),
        ChannelData(
            R.drawable.img,
            "Food Lover",
            "Discover New Recipes"

        ),
        ChannelData(
            R.drawable.meta,
            "Meta",
            "Explore the Void" )     )
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
            TopBar()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )
            MyStatus()
            SampleStatus.forEach { data ->
                StatusItem(statusData = data)
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color.Gray
            )
            Text(
                text = "Channels",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "stay updated on topics that matter to you. Find channels to follow below")
                Spacer(modifier = Modifier.height(32.dp))
                Text("Find Channels to follow")

            }
            Spacer(modifier = Modifier.height(20.dp))
            SampleChannels.forEach { data ->
                ChannelItem(channelData = data)
            }
        }

    }
}