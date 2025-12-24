package com.example.whatsappclone.UserRegistrationScreen

import android.R.attr.fontWeight
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.whatsappclone.R

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
@Preview(showSystemUi = true)
fun UserRegistrationScreen() {
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember {
        mutableStateOf("India")
    }
    var countryCode by remember{
        mutableStateOf("+91")
    }
    var phonenumber by remember{
        mutableStateOf("")
    }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 20.dp, end = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter your phone number",
            fontSize = 20.sp,
            color = colorResource(id = R.color.dark_green),
            fontWeight= FontWeight.Bold,
            modifier = Modifier.padding(top = 15.dp)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row(){
            Text("whatsapp will need to verify your phone number", color = Color.Black)

        }
        Text("what's my number?", color = colorResource(id = R.color.light_green))
        Spacer(modifier = Modifier.height(18.dp))

        TextButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.width(230.dp)
            ) {
                Text(
                    text = selectedCountry,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        tint = colorResource(id = R.color.light_green)
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        listOf("India", "USA", "China", "Canada", "Australia").forEach { country ->
                            DropdownMenuItem(
                                text = { Text(text = country) },
                                onClick = {
                                    selectedCountry = country
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
        HorizontalDivider(
            modifier= Modifier.padding(horizontal = 66.dp),
            thickness = 2.dp,
            color = colorResource(id = R.color.light_green)
        )
        Row(

        ) {
            TextField(
                value = countryCode,
                onValueChange = {
                    countryCode = it
                },
                modifier = Modifier.width(65.dp).align(Alignment.CenterVertically),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedIndicatorColor = colorResource(id = R.color.light_green),
                    focusedIndicatorColor = colorResource(id = R.color.light_green),
                    cursorColor = colorResource(id = R.color.light_green)
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            TextField(
                value = phonenumber, onValueChange = {
                    phonenumber = it
                },
                modifier = Modifier.width(190.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedIndicatorColor = colorResource(id = R.color.light_green),
                    focusedIndicatorColor = colorResource(id = R.color.light_green),

                )
            )
        }
        Spacer(modifier = Modifier.width(28.dp))
        Button(
            onClick = {},
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_green))
        ) {
            Text("Next", fontSize = 16.sp)
        }
    }
}