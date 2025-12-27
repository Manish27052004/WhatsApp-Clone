package com.example.whatsappclone.CallScreen




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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R


data class RecentCallData(val image: Int, val name: String, val time: String, val isMissed: Boolean)

@Composable

fun RecentCallItem(recentCallData: RecentCallData) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = recentCallData.image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(4.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column() {
            Text(text = recentCallData.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Row() {
                Icon(
                    painter = painterResource(R.drawable.baseline_call_missed_24),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = if (recentCallData.isMissed) Color.Red else colorResource(R.color.light_green)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = recentCallData.time, fontSize = 14.sp, color = Color.Gray)
            }

        }
        Spacer(modifier = Modifier.size(12.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
        IconButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterEnd).size(30.dp)

            ) {
            Icon(
                painter = painterResource(id = R.drawable.telephone),
                contentDescription = null
            )
        }
    }
    }
}