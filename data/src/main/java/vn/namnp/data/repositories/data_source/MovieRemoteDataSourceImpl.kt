package vn.namnp.data.repositories.data_source

import retrofit2.Response
import vn.namnp.data.BuildConfig
import vn.namnp.data.api.MovieAPI
import vn.namnp.domain.models.MovieList

class MovieRemoteDataSourceImpl(private val movieAPI: MovieAPI) : MovieRemoteDataSource {
    override suspend fun getListPopularMovies(): Response<MovieList> {
        return movieAPI.getListPopularMovies(BuildConfig.API_KEY)
    }
}