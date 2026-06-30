package com.example.todoapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.bg_top_color),
                        colorResource(id = R.color.bg_bottom_color)
                    )
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.padding(top = 30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.home_icon),
                    "user_image",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(60.dp),
                )

                Spacer(modifier = Modifier.padding(start = 10.dp))

                Column(
                ) {

                    Text(
                        "Aurang Zaib",
                        modifier = Modifier,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "aurangzaibpc@gmail.com",
                        modifier = Modifier,
                        color = colorResource(id = R.color.gray_color),
                        fontSize = 17.sp,
                    )
                }

                Image(
                    painter = painterResource(R.drawable.bell_icon),
                    "setting_icon",
                    modifier = Modifier
                        .padding(start = 50.dp)
                        .size(40.dp)
                )


            }

            Text(
                "Incomplete tasks",
                color = Color.White,
                modifier = Modifier.padding(10.dp, top = 40.dp),
                fontSize = 20.sp
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                items(100) {

                    Text("Item $it")
                    }
                }
            }

        }
    }