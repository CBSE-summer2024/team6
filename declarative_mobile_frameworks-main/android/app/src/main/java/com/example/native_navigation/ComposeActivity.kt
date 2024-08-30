package com.example.native_navigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.native_navigation.home.HOME_ROUTE
import com.example.native_navigation.navigation.AppNavigation
import com.example.native_navigation.ui.theme.AndroidTheme

class ComposeActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(
                        viewModel = viewModel,
                        navController = navController,
                        startDestination = HOME_ROUTE,
                        onBack = {
                            val replyIntent = Intent()
                            setResult(ComponentActivity.RESULT_OK, replyIntent)
                            finish()
                        }
                    )
                }
            }
        }
    }
}