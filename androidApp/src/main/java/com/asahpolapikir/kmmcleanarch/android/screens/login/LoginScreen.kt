package com.asahpolapikir.kmmcleanarch.android.screens.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asahpolapikir.kmmcleanarch.android.theme.MyApplicationTheme
import com.asahpolapikir.kmmcleanarch.data.base.BaseResponse
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit
) {
    val viewModel: LoginViewModel = getViewModel()

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.padding(top = 10.dp).fillMaxWidth()) {
                Text(text = "Email")
            }

            OutlinedTextField(
                modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                value = email.value,
                onValueChange = {
                    email.value = it
                }
            )
            Row(modifier = Modifier.padding(top = 10.dp).fillMaxWidth()) {
                Text(text = "Password")
            }
            TextField(
                modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {
                    password.value = it
                }
            )
            Button(modifier = Modifier.padding(top = 10.dp).fillMaxWidth(), onClick = {
                viewModel.doLogin(email.value, password.value) {
                    when (it) {
                        is BaseResponse.Loading -> {
                            Toast.makeText(context, "is loading...", Toast.LENGTH_SHORT).show()
                        }
                        is BaseResponse.Success -> {
                            navigateToHome.invoke()
                        }
                        is BaseResponse.Error -> {
                            Toast.makeText(context, "${it.e}", Toast.LENGTH_SHORT).show()
                        }
                        else -> {}
                    }
                }
            }) {
                Text(text = "Send")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(navigateToHome = {})
        }
    }
}
