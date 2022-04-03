package vn.namnp.mvvmcleanarchitecturecoroutines.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import vn.namnp.domain.models.MovieList
import vn.namnp.domain.usecases.GetListPopularMoviesUseCase
import javax.inject.Inject
import vn.namnp.domain.utils.Result

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListPopularMoviesUseCase: GetListPopularMoviesUseCase
) : ViewModel() {
    private val TAG = "HOME_VM"
    private val _movieState = mutableStateOf<Result<MovieList>>(Result.Loading())
    val movieState: State<Result<MovieList>>
    get() = _movieState
    init {
        getListOfPopularMovies();
    }

    private fun getListOfPopularMovies() {
        viewModelScope.launch {
            _movieState.value = getListPopularMoviesUseCase.invoke()
            Log.d(TAG, _movieState.value.message.toString() + " "+_movieState.value.data)
        }
    }
}