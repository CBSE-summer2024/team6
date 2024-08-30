package com.example.native_navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.native_navigation.MainViewModel


const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) =
    navigate(SEARCH_ROUTE, navOptions)

fun NavGraphBuilder.searchScreen(
    viewModel: MainViewModel,
    onBackClicked: () -> Unit
) {
    composable(route = SEARCH_ROUTE) {
        SearchScreen(
            viewModel = viewModel,
            onBackClicked = onBackClicked
        )
    }
}