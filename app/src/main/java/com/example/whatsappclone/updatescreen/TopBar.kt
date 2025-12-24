package com.example.whatsappclone.updatescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showSystemUi = true)
fun TopBar() {
    var isSearching by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("")}
    Box(modifier = Modifier.fillMaxWidth()) {
        Column() {
            Row() {
                if(isSearching){
                   TextField(
                       value = search,
                       onValueChange = {
                           search = it
                       },
                       placeholder = {
                           Text("Search")
                       },
                       colors = TextFieldDefaults.colors(
                           focusedContainerColor = Color.Transparent,
                           unfocusedContainerColor = Color.Transparent,
                           focusedIndicatorColor = Color.Transparent,
                           unfocusedIndicatorColor = Color.Transparent
                       ), modifier = Modifier.padding(start = 12.dp), singleLine = true
                   )
                }
                Text( "Updates", fontSize = 28.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp, top = 4.dp, ))
            }
        }
    }

}