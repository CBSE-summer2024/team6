package com.example.native_navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) =
    navigate(SEARCH_ROUTE, navOptions)

fun NavGraphBuilder.searchScreen(
    onBackClicked: () -> Unit
) {
    composable(route = SEARCH_ROUTE) {
        SearchScreen(onBackClicked = onBackClicked)
    }
}