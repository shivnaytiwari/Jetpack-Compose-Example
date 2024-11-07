package com.example.composeexample.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexample.R
import com.example.composeexample.ui.theme.ComposeExampleTheme

@Composable
fun LoginScreen(onClick: (email: String, password: String) -> Unit) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                Modifier
                    .width(40.dp)
                    .height(40.dp)
            )

            Text(
                text = "Please Login Here",
                modifier = Modifier
                    .padding(10.dp),
                fontSize = 22.sp
            )

        }
        TextField(
            value = email, { v ->
                email = v
            },
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            placeholder = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )


        TextField(
            value = password,
            { v ->
                password = v
            },
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {

            Button(modifier = Modifier.padding(10.dp), onClick = {
                Log.e("TAG", "clicked")
                onClick(email, password)
            }) {

                Text(text = "Login")

            }
        }

    }


}

@Preview
@Composable
fun LoginPreview() {
    ComposeExampleTheme {
        LoginScreen { c, v ->

        }
    }
}