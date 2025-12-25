package com.example.whatsappclone.updatescreen


import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R


data class ChannelData(val image: Int, val name: String, val description: String)

@Composable

fun ChannelItem(channelData: ChannelData) {
    var isFollowing by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = channelData.image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(4.dp),


            )
        Spacer(modifier = Modifier.size(12.dp))
        Column() {
            Text(text = channelData.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = channelData.description, fontSize = 14.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.size(12.dp))
        Button(
            onClick = { isFollowing = !isFollowing },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing) Color.Gray else colorResource(id = R.color.light_green),
            ),
            modifier = Modifier.padding(8.dp).height(36.dp)
        ) {
            Text(text= if (isFollowing) "Following" else "Follow",
                color = if (isFollowing) Color.Black else Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}