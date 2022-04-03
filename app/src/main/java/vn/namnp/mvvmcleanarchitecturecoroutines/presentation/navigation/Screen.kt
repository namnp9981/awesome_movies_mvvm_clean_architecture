package vn.namnp.mvvmcleanarchitecturecoroutines.presentation.navigation

sealed class Screen(val route: String) {
    object Home: Screen("HOME")
}