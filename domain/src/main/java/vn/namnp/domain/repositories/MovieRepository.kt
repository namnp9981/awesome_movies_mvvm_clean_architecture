package vn.namnp.domain.repositories
import vn.namnp.domain.models.Movie
import vn.namnp.domain.models.MovieList
import vn.namnp.domain.utils.Result

interface MovieRepository {
    suspend fun getPopularMovies(): Result<MovieList>
}