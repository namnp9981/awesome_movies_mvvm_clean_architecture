package vn.namnp.mvvmcleanarchitecturecoroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vn.namnp.domain.repositories.MovieRepository
import vn.namnp.domain.usecases.GetListPopularMoviesUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository) = GetListPopularMoviesUseCase(movieRepository)
}