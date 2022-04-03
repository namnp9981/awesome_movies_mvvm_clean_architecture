package vn.namnp.mvvmcleanarchitecturecoroutines.presentation.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import vn.namnp.domain.utils.Result
import vn.namnp.mvvmcleanarchitecturecoroutines.R
import vn.namnp.mvvmcleanarchitecturecoroutines.presentation.components.MovieListItem
import vn.namnp.mvvmcleanarchitecturecoroutines.presentation.components.ProgressBarComponent
import vn.namnp.mvvmcleanarchitecturecoroutines.theme.statusBarColor
import vn.namnp.mvvmcleanarchitecturecoroutines.theme.titleColor
import vn.namnp.mvvmcleanarchitecturecoroutines.theme.topAppbarBackgroundColor

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    val systemUIController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor
    val titleColor = MaterialTheme.colors.titleColor
    val topAppBarBackgroundColor = MaterialTheme.colors.topAppbarBackgroundColor
    
    SideEffect {
        systemUIController.setStatusBarColor(
            color = systemBarColor
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name), color = titleColor)
                },
                backgroundColor = topAppBarBackgroundColor
            )
        }
    ) {
        when(val getListMovieResponse = homeViewModel.movieState.value) {
            is Result.Loading -> {
                ProgressBarComponent()
            }
            is Result.Success -> {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    getListMovieResponse.data?.movies?.let { movies ->
                        items(
                            items = movies,
                            itemContent = {
                                MovieListItem(movie = it, navController = navHostController)
                            }
                            
                        )
                    }
                }
            }
            is Result.Error -> {
                Toast.makeText(LocalContext.current, stringResource(id = R.string.toast_error), Toast.LENGTH_LONG).show()
            }
        }
    }
}