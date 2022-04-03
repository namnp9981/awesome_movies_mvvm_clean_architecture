package vn.namnp.mvvmcleanarchitecturecoroutines.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vn.namnp.mvvmcleanarchitecturecoroutines.presentation.screens.home.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
    ){
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen(navHostController = navHostController)
        }
    }
}