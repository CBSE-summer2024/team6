package com.example.native_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.native_navigation.home.homeScreen
import com.example.native_navigation.search.navigateToSearch
import com.example.native_navigation.search.searchScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(onSearchClicked = { navController.navigateToSearch() })

        searchScreen(
            onBackClicked = { navController.popBackStack() }
        )
    }
}