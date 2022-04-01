package vn.namnp.mvvmcleanarchitecturecoroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vn.namnp.data.api.MovieAPI
import vn.namnp.data.repositories.data_source.MovieRemoteDataSource
import vn.namnp.data.repositories.data_source.MovieRemoteDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideMovieRemoteDataSource(movieAPI: MovieAPI) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(movieAPI)
    }
}