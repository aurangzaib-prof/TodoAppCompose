package com.example.todoapp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.ui.components.CustomAuthButton
import com.example.todoapp.ui.components.CustomTextField

@Preview(showBackground = true)
@Composable
fun SignupScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        colorResource(id = R.color.bg_top_color),
                        colorResource(id = R.color.bg_bottom_color)
                    )
                )
            )
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            var email by remember { mutableStateOf("") }

            Image(
                painter = painterResource(R.drawable.checkmark),
                "check",
                modifier = Modifier
                    .size(100.dp)
                    .fillMaxWidth()
                    .padding(start = 0.dp)
                    .align(Alignment.CenterHorizontally),

                )

            Spacer(modifier = Modifier.padding(top = 40.dp))
            Text(
                "Welcome to DO IT ",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 20.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                "Create an account and Join us now!",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.padding(top = 40.dp))
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Name",
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.account_icon),
                        contentDescription = "Email Icon",
                    )
                })
            Spacer(modifier = Modifier.padding(top = 17.dp))

            CustomTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Email",
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.email_leading_ic),
                        contentDescription = "Email Icon",
                    )
                })

            Spacer(modifier = Modifier.padding(top = 17.dp))
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                hint = "Password",
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.pass_leading_ic),
                        contentDescription = "Pass Icon",
                    )
                })
            Spacer(modifier = Modifier.padding(top = 20.dp))
            CustomAuthButton(onClick = {

            }, modifier = Modifier.fillMaxWidth(), text = "Sign Up")
            Spacer(modifier = Modifier.padding(top = 20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Already have an account?",
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 20.dp)
                )

                Text(
                    "sign in",
                    fontSize = 20.sp,
                    color = colorResource(R.color.text_blue_color),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 5.dp),
                )

            }
        }
    }
}