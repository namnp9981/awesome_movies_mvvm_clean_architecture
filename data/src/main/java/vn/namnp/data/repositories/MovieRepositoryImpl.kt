package vn.namnp.data.repositories

import vn.namnp.data.repositories.data_source.MovieRemoteDataSource
import vn.namnp.domain.models.MovieList
import vn.namnp.domain.repositories.MovieRepository
import vn.namnp.domain.utils.Result

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource)
    : MovieRepository {
    override suspend fun getPopularMovies(): Result<MovieList> {
        val response = movieRemoteDataSource.getListPopularMovies()
        if(response.isSuccessful){
            response.body()?.let { result ->
                return Result.Success(result)
            }
        }
        return Result.Error(message = response.message());
    }
}