package vn.namnp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import vn.namnp.data.constants.Constant
import vn.namnp.domain.models.MovieList

interface MovieAPI {

    @GET("movie/popular")
    suspend fun getListPopularMovies(
        @Query(Constant.API_KEY) apiKey: String
    ) : Response<MovieList>
}