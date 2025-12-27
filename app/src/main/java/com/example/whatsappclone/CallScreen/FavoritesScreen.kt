package com.example.whatsappclone.CallScreen

import android.widget.Space
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R

@Composable
@Preview(showSystemUi = true)
fun FavoritesSection()
{
    var SampleFavorites = listOf(
        FavoritesContent(
            R.drawable.ajay_devgn,
            "Ajay Devgn"
        ),
        FavoritesContent(
            R.drawable.bhuvan_bam,
            "Bhuvan Bam"
        ),
        FavoritesContent(
            R.drawable.hrithik_roshan,
            "Hrithik Roshan"
        ),
        FavoritesContent(
            R.drawable.salman_khan,
            "Salman Khan"
        ),
        FavoritesContent(
            R.drawable.salman_khan,
            "Salman Khan"
        )
    )
    Column(
        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Favorites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
            SampleFavorites.forEach { data ->
                FavoriteItems(favoritesContent = data)
            }
        }
    }
}
data class FavoritesContent(
    val image:Int,
    val name: String,
)