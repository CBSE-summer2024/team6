package com.example.native_navigation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) =
    navigate(HOME_ROUTE, navOptions)

fun NavGraphBuilder.homeScreen(
    onSearchClicked: () -> Unit,
    onBack: () -> Unit = {}
) {
    composable(route = HOME_ROUTE) {
        HomeScreen(
            onSearchClicked = onSearchClicked,
            onBack = onBack
        )
    }
}