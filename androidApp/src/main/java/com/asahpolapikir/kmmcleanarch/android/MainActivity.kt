package com.asahpolapikir.kmmcleanarch.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.asahpolapikir.kmmcleanarch.android.navigation.NavGraph
import com.asahpolapikir.kmmcleanarch.android.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    MyApplicationTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}

