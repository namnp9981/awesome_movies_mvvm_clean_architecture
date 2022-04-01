package vn.namnp.mvvmcleanarchitecturecoroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vn.namnp.data.repositories.MovieRepositoryImpl
import vn.namnp.data.repositories.data_source.MovieRemoteDataSource
import vn.namnp.domain.repositories.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource)
    }
}