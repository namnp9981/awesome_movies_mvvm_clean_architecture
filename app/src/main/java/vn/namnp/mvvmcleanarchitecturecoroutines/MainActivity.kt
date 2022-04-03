package vn.namnp.mvvmcleanarchitecturecoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vn.namnp.mvvmcleanarchitecturecoroutines.presentation.navigation.NavGraph
import vn.namnp.mvvmcleanarchitecturecoroutines.theme.MovieTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieTheme {
                navHostController = rememberNavController()
                NavGraph(navHostController = navHostController)
            }
        }
    }
}