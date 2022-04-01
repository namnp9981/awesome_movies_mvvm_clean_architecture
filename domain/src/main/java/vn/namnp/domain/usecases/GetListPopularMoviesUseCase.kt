package vn.namnp.domain.usecases
import vn.namnp.domain.repositories.MovieRepository

class GetListPopularMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.getPopularMovies()
}