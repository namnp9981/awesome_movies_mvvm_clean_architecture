package vn.namnp.data.repositories.data_source

import retrofit2.Response
import vn.namnp.domain.models.MovieList

interface MovieRemoteDataSource {
    suspend fun getListPopularMovies(): Response<MovieList>
}