package com.example.native_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.native_navigation.MainViewModel
import com.example.native_navigation.home.homeScreen
import com.example.native_navigation.search.navigateToSearch
import com.example.native_navigation.search.searchScreen

@Composable
fun AppNavigation(
    viewModel: MainViewModel,
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    onBack: () -> Unit = {}
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(
            onSearchClicked = { navController.navigateToSearch() },
            onBack = onBack
        )

        searchScreen(
            viewModel = viewModel,
            onBackClicked = { navController.popBackStack() }
        )
    }
}